package gcyl.entity.order.service.impl;

import gcyl.entity.common.Constant;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.order.OrderStateEnum;
import gcyl.entity.common.enums.order.PayEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.common.utils.SnGenerate;
import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.mapper.ext.OrderDetailExtMapper;
import gcyl.entity.domain.mapper.ext.OrderExtMapper;
import gcyl.entity.domain.model.Order;
import gcyl.entity.domain.model.OrderDetail;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.service.ICartService;
import gcyl.entity.order.request.OrderCreateRequest;
import gcyl.entity.order.service.IOrderService;
import gcyl.entity.order.service.IOrderStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lican
 * @date 2018/12/12
 */
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
    SnGenerate snGenerate;

    /**
     * 订单创建 //TODO controller抵扣金额验证
     *
     * @param request  订单信息
     * @return 创建结果
     */
    @Override
    @Transactional
    public Result create(OrderCreateRequest request) {
        Result result = new Result();
        long shopId = request.getShopId();
        long userId = request.getUserId();
        int tableNum = request.getTableNum();
        int payWay = request.getPayWay();
        BigDecimal goodsAmount = request.getGoodsAmount().setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal deductAmount = request.getDeductAmount().setScale(2, BigDecimal.ROUND_DOWN);
        Integer deductMethod = request.getDeductMethod();
        BigDecimal consumption = request.getConsumption().setScale(2, BigDecimal.ROUND_DOWN);
        Integer personNum = request.getPersonNum();

        //TODO 验证购物车列表是否发生变化
        List<CartForm> cartForms = cartService.getTable(shopId, tableNum);

        String orderSn = snGenerate.snGenerate(Constant.O_SN_PREFIX);
        BigDecimal settleAmount = goodsAmount.subtract(deductAmount);

        //订单基本信息插入
        Order order = new Order();
        order.setOrderSn(orderSn);
        order.setOrderState(OrderStateEnum.WAIT_RECEIVE.getCode());
        order.setIsPay(PayEnum.NOT_PAID.getCode());
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
        order.setGmtCreate(DateUtils.getDate());

        int i = orderExtMapper.insertSelective(order);
        if (i <= 0) {
            result.error(ResultEnum.O1001);
            return result;
        }

        //批量插入订单明细(订单商品信息)
        long orderId = order.getId();
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (CartForm cartForm : cartForms) {
            long goodsId = cartForm.getGoodsId();
            String goodsName = cartForm.getGoodsName();
            String goods_unit = cartForm.getGoodsUnit();
            String goods_img = cartForm.getGoodsImage();
            long specId = cartForm.getSpecId();
            String specName = cartForm.getSpecName();
            BigDecimal specPrice = cartForm.getSpecPrice();
            int num = cartForm.getNum();

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
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
        i = orderDetailExtMapper.batchInsert(orderDetails);
        if (i <= 0) {
            result.error(ResultEnum.O1002);
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
     * @return
     */
    @Override
    public Result changeState(Order order, OrderStateEnum stateEnum) {
        Result result = new Result();
        if (order.getId() == null || stateEnum == null) {
            result.error(ResultEnum.O2010);
            return result;
        }

        switch (stateEnum) {
            case WAIT_SERVING:
                return stateService.toWaitServing(order);
            case FINISH_SERVING:
                return stateService.toFinishServing(order);
            case FINISH:
                return stateService.toFinish(order);
            case CLOSE:
                return stateService.toClose(order);
        }

        result.error(ResultEnum.O2011);
        return result;
    }
}
