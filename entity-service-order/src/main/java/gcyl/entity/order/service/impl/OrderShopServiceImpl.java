package gcyl.entity.order.service.impl;

import com.github.pagehelper.PageHelper;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.goods.StockEnum;
import gcyl.entity.common.enums.order.OrderStateEnum;
import gcyl.entity.common.enums.order.PayEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.mapper.ex.OrderExtMapper;
import gcyl.entity.domain.model.Order;
import gcyl.entity.domain.model.OrderExample;
import gcyl.entity.domain.model.ex.OrderEx;
import gcyl.entity.domain.model.form.OrderGoodsForm;
import gcyl.entity.goods.service.IGoodsService;
import gcyl.entity.order.Enum.SListTypeEnum;
import gcyl.entity.order.request.OrderSListRequest;
import gcyl.entity.order.service.IOrderService;
import gcyl.entity.order.service.IOrderShopService;
import gcyl.entity.domain.model.vo.OrderSNumVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 店铺订单管理
 *
 * @author lican
 * @date 2018/12/28
 */
@Slf4j
@Service
public class OrderShopServiceImpl implements IOrderShopService {
    
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderExtMapper orderExtMapper;

    @Autowired
    IOrderService orderService;
    @Autowired
    IGoodsService goodsService;

    /**
     * 获取订单数量
     *
     * @param shopId  店铺ID
     * @return 订单数量
     */
    @Override
    public OrderSNumVO orderNum(long shopId) {
        Map<String, Object> paramMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        paramMap.put("orderStates", list);
        paramMap.put("shopId", shopId);
        paramMap.put("shopCutOff", false);

        list.add(OrderStateEnum.WR.getCode());
        int waitReceive = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.WS.getCode());
        int waitServing = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.FH.getCode());
        list.add(OrderStateEnum.EV.getCode());
        int finish = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.CS.getCode());
        int close = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.WS.getCode());
        list.add(OrderStateEnum.FS.getCode());
        paramMap.put("isPay", false);
        int waitPay = orderExtMapper.countByMap(paramMap);

        OrderSNumVO orderSNumVO = new OrderSNumVO();
        orderSNumVO.setWaitReceive(waitReceive);
        orderSNumVO.setWaitServing(waitServing);
        orderSNumVO.setWaitPay(waitPay);
        orderSNumVO.setFinish(finish);
        orderSNumVO.setClose(close);

        return orderSNumVO;
    }

    /**
     * 店铺订单列表
     *
     * @param request  列表请求参数
     * @return 订单列表
     */
    @Override
    public List<OrderEx> orderList(OrderSListRequest request) {
        long shopId = request.getShopId();
        int pageSize = request.getPageSize();
        int pageNum = request.getPageNum();
        String orderSn = request.getOrderSn();
        SListTypeEnum typeEnum = request.getListType();

        List<Integer> orderStates = new ArrayList<>();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("shopId", shopId);
        if (typeEnum != null) {
            switch (typeEnum) {
                case WR:
                    orderStates.add(OrderStateEnum.WR.getCode());
                    break;
                case WS:
                    orderStates.add(OrderStateEnum.WS.getCode());
                    break;
                case WP:
                    orderStates.add(OrderStateEnum.WS.getCode());
                    orderStates.add(OrderStateEnum.FS.getCode());
                    paramMap.put("isPay", PayEnum.NOT_PAID.getCode());
                    break;
                case FH:
                    orderStates.add(OrderStateEnum.FH.getCode());
                    orderStates.add(OrderStateEnum.EV.getCode());
                    break;
                case CS:
                    orderStates.add(OrderStateEnum.CS.getCode());
                    break;
            }
            paramMap.put("orderStates", orderStates);
        }
        if (StringUtils.isNotBlank(orderSn)) paramMap.put("orderSn", orderSn);

        PageHelper.startPage(pageNum, pageSize);
        return orderExtMapper.selectShopOdList(paramMap);
    }

    /**
     * 店铺订单详情
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @return 订单详情
     */
    @Override
    public OrderEx orderDetail(long shopId, long orderId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("shopId", shopId);
        paramMap.put("orderId", orderId);
        return orderExtMapper.selectShopOdDetail(paramMap);
    }

    /**
     * 拒绝接单
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @param reason   拒接原因
     */
    @Override
    @Transactional
    public Result refuse(long shopId, long orderId, String reason) {
        Result result = this.isShopOrder(shopId, orderId);
        if (!result.isSuccess()) return result;

        //将库存加回去
        List<OrderGoodsForm> goodsForms = orderExtMapper.selectOrderGoodsNum(orderId);
        goodsForms = goodsForms.stream().sorted(Comparator.comparing(OrderGoodsForm::getSpecId)).collect(Collectors.toList());
        for (OrderGoodsForm goodsForm : goodsForms) {
            long specId = goodsForm.getSpecId();
            int num = goodsForm.getSpecNum();
            result = goodsService.changeStock(specId, num, StockEnum.ADD);
            if (!result.isSuccess()) return result;
        }

        Order order = new Order();
        order.setId(orderId);
        order.setDescription(reason);
        return orderService.changeState(order, OrderStateEnum.CS);
    }

    /**
     * 接单
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    @Override
    public Result receive(long shopId, long orderId) {
        Result result = this.isShopOrder(shopId, orderId);
        if (!result.isSuccess()) return result;

        Order order = new Order();
        order.setId(orderId);
        return orderService.changeState(order, OrderStateEnum.WS);
    }

    /**
     * 上菜完成
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    @Override
    public Result finishServing(long shopId, long orderId) {
        Result result = this.isShopOrder(shopId, orderId);
        if (!result.isSuccess()) return result;

        boolean isPay = orderExtMapper.selectIsPay(orderId);
        Order order = new Order();
        order.setId(orderId);
        if (isPay) {
            return orderService.changeState(order, OrderStateEnum.FH);
        } else {
            return orderService.changeState(order, OrderStateEnum.FS);
        }
    }

    /**
     * 确认收款
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    @Override
    public Result confirmReceipt(long shopId, long orderId) {
        Result result = this.isShopOrder(shopId, orderId);
        if (!result.isSuccess()) return result;

        //订单状态验证
        Order oldOrder = orderExtMapper.selectForStateUp(orderId);
        int orderStare = oldOrder.getOrderState();
        if (orderStare != OrderStateEnum.FS.getCode()
                && orderStare != OrderStateEnum.WS.getCode()) {
            log.info(ResultEnum.O2015.toString());
            result.error(ResultEnum.O2015);
            return result;
        }

        long now = DateUtils.getDateTime();

        Order order = new Order();
        order.setId(orderId);
        order.setGmtPay(now);
        order.setGmtModify(now);

        //判断是否上菜完成,若完成则修改订单为已完成
        if (orderStare == OrderStateEnum.FS.getCode()) {
            return orderService.changeState(order, OrderStateEnum.FH);
        }

        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i <= 0) {
            log.info(ResultEnum.O2021.toString());
            result.error(ResultEnum.O2021);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 判断是否店铺订单
     *
     * @param shopId  店铺ID
     * @param orderId 订单ID
     * @return success = true 是
     */
    @Override
    public Result isShopOrder(long shopId, long orderId) {
        Result result = new Result();
        OrderExample example = new OrderExample();
        example.createCriteria().andIdEqualTo(orderId).andShopIdEqualTo(shopId);
        int count = orderMapper.countByExample(example);
        if (count <= 0) {
            log.info(ResultEnum.O0001.toString());
            result.error(ResultEnum.O0001);
            return result;
        }
        result.success();
        return result;
    }
}
