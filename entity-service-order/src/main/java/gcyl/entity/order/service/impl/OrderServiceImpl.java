package gcyl.entity.order.service.impl;

import gcyl.entity.common.constant.Constant;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.goods.StockEnum;
import gcyl.entity.common.enums.order.OrderStateEnum;
import gcyl.entity.common.enums.order.PayEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.common.utils.SnGenerate;
import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.mapper.ex.OrderDetailExtMapper;
import gcyl.entity.domain.mapper.ex.OrderExtMapper;
import gcyl.entity.domain.model.Order;
import gcyl.entity.domain.model.OrderDetail;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.service.ICartService;
import gcyl.entity.goods.service.IGoodsService;
import gcyl.entity.order.form.SpecNumForm;
import gcyl.entity.order.request.OrderCreateRequest;
import gcyl.entity.order.request.OrderPaidRequest;
import gcyl.entity.order.service.IOrderService;
import gcyl.entity.order.service.IOrderStateService;
import gcyl.entity.order.vo.OrderCreateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 订单管理
 *
 * @author lican
 * @date 2018/12/12
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {
    
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderExtMapper orderExtMapper;
    @Autowired
    OrderDetailExtMapper orderDetailExtMapper;

    @Autowired
    ICartService cartService;
    @Autowired
    IOrderStateService stateService;
    @Autowired
    IGoodsService goodsService;
    @Autowired
    SnGenerate snGenerate;

    /**
     * 订单创建
     *
     * @param request  订单信息
     */
    @Override
    @Transactional
    public Result create(OrderCreateRequest request) {
        long shopId = request.getShopId();
        int tableNum = request.getTableNum();

        //验证购物车是否发生变化
        List<CartForm> cartForms = cartService.get(shopId, tableNum);
        List<SpecNumForm> specNumForms = request.getSpecNumForms();
        Result result = this.isCartChanged(cartForms, specNumForms);
        if (!result.isSuccess()) return result;

        long userId = request.getUserId();
        int payWay = request.getPayWay();
        BigDecimal goodsAmount = request.getGoodsAmount().setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal cartGoodsAmount = new BigDecimal(0); //购物车商品价格
        BigDecimal deductAmount = request.getDeductAmount().setScale(2, BigDecimal.ROUND_DOWN);
        Integer deductMethod = request.getDeductMethod();
        BigDecimal consumption = request.getConsumption().setScale(2, BigDecimal.ROUND_DOWN);
        Integer personNum = request.getPersonNum();
        BigDecimal settleAmount = goodsAmount.subtract(deductAmount);
        long now = DateUtils.getDateTime();

        //获取默认商品
        List<CartForm> defaults = cartService.getDefault(shopId);
        cartForms.addAll(defaults);

        //记录商品数量做销量批量修改，暂不做数据一致性判断
        List<Map<String, Object>> stockList = new ArrayList<>();

        //批量插入订单明细(订单商品信息)
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (CartForm cartForm : cartForms) {
            long goodsId = cartForm.getGoodsId();
            String goodsName = cartForm.getGoodsName();
            String goods_unit = cartForm.getGoodsUnit();
            String goods_img = cartForm.getGoodsImg();
            long specId = cartForm.getSpecId();
            String specName = cartForm.getSpecName();
            BigDecimal specPrice = cartForm.getSpecPrice();
            Integer num = cartForm.getNum();
            boolean isDefault = cartForm.getIsDefault();
            if (isDefault) num = personNum; //默认商品数量等于人数

            //计算购物车商品总价
            cartGoodsAmount = cartGoodsAmount.add(specPrice.multiply(new BigDecimal(num)));

            //记录销量
            Map<String, Object> stockMap = new HashMap<>();
            stockMap.put("goodsId", goodsId);
            stockMap.put("specId", specId);
            stockMap.put("num", num);
            stockMap.put("gmtModify", now);
            stockList.add(stockMap);

            //记录订单明细
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setGoodsId(goodsId);
            orderDetail.setGoodsName(goodsName);
            orderDetail.setGoodsUnit(goods_unit);
            orderDetail.setGoodsImg(goods_img);
            orderDetail.setSpecId(specId);
            orderDetail.setSpecName(specName);
            orderDetail.setSpecPrice(specPrice);
            orderDetail.setSpecNum(num);
            orderDetails.add(orderDetail);
        }

        //判断前后端价格计算是否一致
        if (goodsAmount.compareTo(cartGoodsAmount) != 0) {
            result.error(ResultEnum.O1004);
            return result;
        }

        //修改商品库存
        cartForms = cartForms.stream()
                .sorted(Comparator.comparing(CartForm::getSpecId)) //按顺序修改，避免死锁
                .collect(Collectors.toList());
        for (CartForm cartForm : cartForms) {
            long specId = cartForm.getSpecId();
            String goodsName = cartForm.getGoodsName();
            String specName = cartForm.getSpecName();
            Integer num = cartForm.getNum();
            if (cartForm.getIsDefault()) num = personNum;
            result = goodsService.changeStock(specId, num, StockEnum.REDUCE);
            if (!result.isSuccess()) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                result.setMsg(result.getMsg() + ":" + goodsName + specName);
                return result;
            }
        }

        //订单基本信息插入
        String orderSn = snGenerate.snGenerate(Constant.O_SN_PREFIX);
        Order order = new Order();
        order.setOrderSn(orderSn);
        order.setOrderState(OrderStateEnum.WR.getCode());
        order.setIsPay(PayEnum.NPD.getCode());
        order.setPayWay(payWay);
        order.setShopId(shopId);
        order.setUserId(userId);
        order.setTableNum(tableNum);
        order.setConsumeAmount(goodsAmount);
        order.setDeductAmount(deductAmount);
        order.setSettleAmount(settleAmount);
        order.setDeductMethod(deductMethod);
        order.setConsumption(consumption);
        order.setPersonNum(personNum);
        order.setGmtCreate(now);
        order.setGmtModify(now);

        int i = orderExtMapper.insertSelective(order);
        if (i <= 0) {
            log.info(ResultEnum.O1001.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.error(ResultEnum.O1001);
            return result;
        }

        //批量插入订单明细
        long orderId = order.getId();
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrderId(orderId);
        }
        i = orderDetailExtMapper.batchInsert(orderDetails);
        if (i <= 0) {
            log.info(ResultEnum.O1002.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.error(ResultEnum.O1002);
            return result;
        }

        //批量增加商品销量
        goodsService.addSales(stockList);

        //清空购物车
        result = cartService.clear(shopId, tableNum);
        if (!result.isSuccess()) {
            log.info(ResultEnum.O1003.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.error(ResultEnum.O1003);
            return result;
        }

        //下单返回
        OrderCreateVO createVO = new OrderCreateVO();
        createVO.setOrderId(orderId);
        createVO.setOrderSn(orderSn);
        createVO.setSettleAmount(settleAmount);
        createVO.setGmtCreate(now);

        result.success(createVO);
        return result;
    }

    /**
     * 订单支付完成
     * 先保证流程的执行，防止用户支付成功后修改订单支付状态失败
     * 若要求保证payMethod的正确性，可通过PayMethodEnum验证
     *
     * @param request 订单支付信息
     */
    @Override
    public Result paid(OrderPaidRequest request) {
        long orderId = request.getOrderId();
        int payMethod = request.getPayMethod();
        long now = DateUtils.getDateTime();

        Order order = new Order();
        order.setId(orderId);
        order.setPayMethod(payMethod);
        order.setIsPay(PayEnum.PAID.getCode());
        order.setGmtPay(now);
        order.setGmtModify(now);

        Result result = new Result();
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i <= 0) {
            result.error(ResultEnum.O1011);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 验证购物是否发生变化
     *
     * @param cartForms     购物车商品
     * @param specNumForms  订单商品
     */
    private Result isCartChanged(List<CartForm> cartForms, List<SpecNumForm> specNumForms) {
        Result result = new Result();
        if (cartForms.size() != specNumForms.size()) {
            result.error(ResultEnum.CT0001);
            return result;
        }

        Set<String> old = new HashSet<>();
        for (CartForm form : cartForms) {
            old.add(form.getSpecId() + ":" + form.getNum());
        }
        Set<String> all = new HashSet<>(old);

        Set<String> now = new HashSet<>();
        for (SpecNumForm form : specNumForms) {
            now.add(form.getSpecId() + ":" + form.getNum());
        }
        all.addAll(now);

        if (all.size() != old.size() || all.size() != now.size()) {
            result.error(ResultEnum.CT0001);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 订单状态修改
     *
     * @param order     订单信息
     * @param stateEnum 新订单状态
     */
    @Override
    public Result changeState(Order order, OrderStateEnum stateEnum) {
        Result result = new Result();
        if (order.getId() == null || stateEnum == null) {
            log.info(ResultEnum.O2010.toString());
            result.error(ResultEnum.O2010);
            return result;
        }

        switch (stateEnum) {
            case WS:
                return stateService.toWaitServing(order);
            case FS:
                return stateService.toFinishServing(order);
            case FH:
                return stateService.toFinish(order);
            case CS:
                return stateService.toClose(order);
        }

        log.info(ResultEnum.O2011.toString());
        result.error(ResultEnum.O2011);
        return result;
    }
}
