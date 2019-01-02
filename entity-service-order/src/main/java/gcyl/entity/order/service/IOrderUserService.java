package gcyl.entity.order.service;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.ext.OrderExt;
import gcyl.entity.domain.model.vo.OrderUNumVO;
import gcyl.entity.order.request.OrderUListRequest;

import java.util.List;

/**
 * 用户订单管理
 *
 * @author lican
 * @date 2018/12/28
 */
public interface IOrderUserService {

    /**
     * 获取订单数量
     *
     * @param userId  店铺ID
     * @return 订单数量
     */
    OrderUNumVO orderNum(long userId);

    /**
     * 用户订单列表
     *
     * @param request  列表请求参数
     * @return 订单列表
     */
    List<OrderExt> orderList(OrderUListRequest request);

    /**
     * 用户订单详情
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 订单详情
     */
    OrderExt orderDetail(long userId, long orderId);

    /**
     * 判断是否用户订单
     *
     * @param userId  店铺ID
     * @param orderId 订单ID
     * @return success = true 是
     */
    Result isUserOrder(long userId, long orderId);
}
