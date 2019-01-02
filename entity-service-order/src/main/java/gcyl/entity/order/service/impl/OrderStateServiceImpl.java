package gcyl.entity.order.service.impl;

import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.order.OrderStateEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.mapper.ext.OrderExtMapper;
import gcyl.entity.domain.model.Order;
import gcyl.entity.order.service.IOrderStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 订单状态管理
 *
 * @author lican
 * @date 2018/12/28
 */
@Service
public class OrderStateServiceImpl implements IOrderStateService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderExtMapper orderExtMapper;

    /**
     * 修改为待上菜（上菜中）
     * @param order 订单信息
     */
    @Override
    public Result toWaitServing(Order order) {
        Result result = new Result();
        long orderId = order.getId();
        Order oldOrder = orderExtMapper.selectForStateUp(orderId);
        if (oldOrder.getOrderState() != OrderStateEnum.WAIT_RECEIVE.getCode()) {
            result.error(ResultEnum.O2012);
            return result;
        }

        //修改订单为待上菜
        order.setOrderState(OrderStateEnum.WAIT_SERVING.getCode());
        order.setGmtReceive(DateUtils.getDate());
        int i = orderMapper.updateByPrimaryKeySelective(oldOrder);
        if (i <= 0) {
            result.error(ResultEnum.O2002);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 修改为上菜完成
     * @param order 订单信息
     */
    @Override
    public Result toFinishServing(Order order) {
        Result result = new Result();
        long orderId = order.getId();
        boolean isPay = order.getIsPay();
        Order oldOrder = orderExtMapper.selectForStateUp(orderId);
        if (oldOrder.getOrderState() != OrderStateEnum.WAIT_SERVING.getCode()) {
            result.error(ResultEnum.O2013);
            return result;
        }

        Date now = DateUtils.getDate();
        order.setGmtServingFinish(now);
        //若已支付，则修改为已完成，若未支付，则修改为上菜完成
        if (isPay) {
            order.setOrderState(OrderStateEnum.FINISH.getCode());
            order.setGmtFinish(now);
        } else {
            order.setOrderState(OrderStateEnum.FINISH_SERVING.getCode());
        }
        int i = orderMapper.updateByPrimaryKeySelective(oldOrder);
        if (i <= 0) {
            result.error(ResultEnum.O2002);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 修改为订单完成
     * @param order 订单信息
     */
    @Override
    public Result toFinish(Order order) {
        Result result = new Result();
        long orderId = order.getId();
        Order oldOrder = orderExtMapper.selectForStateUp(orderId);
        if (oldOrder.getOrderState() != OrderStateEnum.FINISH_SERVING.getCode()) {
            result.error(ResultEnum.O2014);
            return result;
        }

        //修改订单为已完成
        order.setOrderState(OrderStateEnum.FINISH.getCode());
        order.setGmtFinish(DateUtils.getDate());
        int i = orderMapper.updateByPrimaryKeySelective(oldOrder);
        if (i <= 0) {
            result.error(ResultEnum.O2002);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 修改为已关闭
     * @param order 订单信息
     */
    @Override
    public Result toClose(Order order) {
        Result result = new Result();
        long orderId = order.getId();
        Order oldOrder = orderExtMapper.selectForStateUp(orderId);
        if (oldOrder.getOrderState() != OrderStateEnum.WAIT_RECEIVE.getCode()) {
            result.error(ResultEnum.O2012);
            return result;
        }

        //修改订单为已关闭
        order.setOrderState(OrderStateEnum.CLOSE.getCode());
        int i = orderMapper.updateByPrimaryKeySelective(oldOrder);
        if (i <= 0) {
            result.error(ResultEnum.O2002);
            return result;
        }

        result.success();
        return result;
    }
}
