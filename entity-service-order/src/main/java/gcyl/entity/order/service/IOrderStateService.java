package gcyl.entity.order.service;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.Order;

/**
 * 订单状态管理
 *
 * @author lican
 * @date 2018/12/28
 */
public interface IOrderStateService {

    /**
     * 修改为待上菜（上菜中）
     * @param order 订单信息
     */
    Result toWaitServing(Order order);

    /**
     * 修改为上菜完成
     * @param order 订单信息
     */
    Result toFinishServing(Order order);

    /**
     * 修改为订单完成
     * @param order 订单信息
     */
    Result toFinish(Order order);

    /**
     * 修改为已关闭
     * @param order 订单信息
     */
    Result toClose(Order order);
}
