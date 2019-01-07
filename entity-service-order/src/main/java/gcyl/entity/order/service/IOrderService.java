package gcyl.entity.order.service;

import gcyl.entity.common.enums.goods.StockEnum;
import gcyl.entity.common.enums.order.OrderStateEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.Order;
import gcyl.entity.order.request.OrderCreateRequest;

/**
 * 订单管理类
 *
 * @author lican
 * @date 2018/12/12
 */
public interface IOrderService {

    /**
     * 订单创建
     *
     * @param request  订单信息
     * @return 创建结果
     */
    Result create(OrderCreateRequest request);

    /**
     * 订单状态修改
     *
     * @param order     订单信息
     * @param stateEnum 新订单状态
     * @return 修改返回
     */
    Result changeState(Order order, OrderStateEnum stateEnum);
}
