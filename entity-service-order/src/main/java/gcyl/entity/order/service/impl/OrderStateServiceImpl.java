package gcyl.entity.order.service.impl;

import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.order.OrderStateEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.mapper.ex.OrderExtMapper;
import gcyl.entity.domain.model.Order;
import gcyl.entity.order.service.IOrderStateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单状态管理
 *
 * @author lican
 * @date 2018/12/28
 */
@Service
public class OrderStateServiceImpl implements IOrderStateService {

    private static Logger logger = LoggerFactory.getLogger(OrderStateServiceImpl.class);

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
        if (oldOrder.getOrderState() != OrderStateEnum.WR.getCode()) {
            logger.info(ResultEnum.O2012.toString());
            result.error(ResultEnum.O2012);
            return result;
        }

        long now = DateUtils.getDateTime();

        //修改订单为待上菜
        order.setOrderState(OrderStateEnum.WS.getCode());
        order.setGmtReceive(now);
        order.setGmtModify(now);
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i <= 0) {
            logger.info(ResultEnum.O2002.toString());
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
        Order oldOrder = orderExtMapper.selectForStateUp(orderId);
        if (oldOrder.getOrderState() != OrderStateEnum.WS.getCode()) {
            logger.info(ResultEnum.O2013.toString());
            result.error(ResultEnum.O2013);
            return result;
        }

        long now = DateUtils.getDateTime();

        order.setGmtServingFinish(DateUtils.getDateTime());
        order.setGmtModify(now);
        order.setOrderState(OrderStateEnum.FS.getCode());
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i <= 0) {
            logger.info(ResultEnum.O2002.toString());
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
        if (oldOrder.getOrderState() != OrderStateEnum.WS.getCode()
                && oldOrder.getOrderState() != OrderStateEnum.FS.getCode()) {
            logger.info(ResultEnum.O2014.toString());
            result.error(ResultEnum.O2014);
            return result;
        }

        long now = DateUtils.getDateTime();

        //修改订单为已完成
        if (oldOrder.getOrderState() == OrderStateEnum.WS.getCode())
            order.setGmtServingFinish(now);
        order.setOrderState(OrderStateEnum.FH.getCode());
        order.setGmtFinish(now);
        order.setGmtModify(now);
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i <= 0) {
            logger.info(ResultEnum.O2002.toString());
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
        if (oldOrder.getOrderState() != OrderStateEnum.WR.getCode()) {
            logger.info(ResultEnum.O2012.toString());
            result.error(ResultEnum.O2012);
            return result;
        }

        long now = DateUtils.getDateTime();

        //修改订单为已关闭
        order.setOrderState(OrderStateEnum.CS.getCode());
        order.setGmtModify(now);
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i <= 0) {
            logger.info(ResultEnum.O2002.toString());
            result.error(ResultEnum.O2002);
            return result;
        }

        result.success();
        return result;
    }
}
