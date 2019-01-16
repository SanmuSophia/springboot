package gcyl.entity.order.service;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.ex.OrderEx;
import gcyl.entity.order.request.OrderSListRequest;
import gcyl.entity.domain.model.vo.OrderSNumVO;

import java.util.List;

/**
 * 店铺订单管理
 *
 * @author lican
 * @date 2018/12/28
 */
public interface IOrderShopService {

    /**
     * 获取订单数量
     *
     * @param shopId  店铺ID
     * @return 订单数量
     */
    OrderSNumVO orderNum(long shopId);

    /**
     * 店铺订单列表
     *
     * @param request  列表请求参数
     * @return 订单列表
     */
    List<OrderEx> orderList(OrderSListRequest request);

    /**
     * 店铺订单详情
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @return 订单详情
     */
    OrderEx orderDetail(long shopId, long orderId);

    /**
     * 拒绝接单
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @param reason   拒接原因
     */
    Result refuse(long shopId, long orderId, String reason);

    /**
     * 接单
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    Result receive(long shopId, long orderId);

    /**
     * 上菜完成
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    Result finishServing(long shopId, long orderId);

    /**
     * 确认收款
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    Result confirmReceipt(long shopId, long orderId);

    /**
     * 判断是否店铺订单
     *
     * @param shopId  店铺ID
     * @param orderId 订单ID
     * @return success = true 是
     */
    Result isShopOrder(long shopId, long orderId);
}
