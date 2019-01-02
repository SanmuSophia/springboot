package gcyl.entity.domain.mapper.ext;

import gcyl.entity.domain.model.Order;
import gcyl.entity.domain.model.ext.OrderExt;
import gcyl.entity.domain.model.vo.OrderSNumVO;
import gcyl.entity.domain.model.vo.OrderUNumVO;

import java.util.List;
import java.util.Map;

public interface OrderExtMapper {

    int insertSelective(Order record);

    /**
     * 计算店铺订单数量
     *
     * @param shopId  店铺ID
     * @return 订单数量
     */
    OrderSNumVO countShopOdNum(long shopId);

    /**
     * 计算用户订单数量
     *
     * @param userId  用户ID
     * @return 订单数量
     */
    OrderUNumVO countUserOdNum(long userId);

    /**
     * 查询订单状态修改信息
     *
     * @param orderId 订单ID
     */
    Order selectForStateUp(long orderId);

    /**
     * 根据条件搜索店铺订单列表
     *
     * @param paramMap  搜索条件
     * @return 订单列表
     */
    List<OrderExt> selectShopOdList(Map<String, Object> paramMap);

    /**
     * 获取店铺订单详情
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @return 订单详情
     */
    OrderExt selectShopOdDetail(long shopId, long orderId);

    /**
     * 根据条件搜索用户订单列表
     *
     * @param paramMap  搜索条件
     * @return 订单列表
     */
    List<OrderExt> selectUserOdList(Map<String, Object> paramMap);

    /**
     * 获取用户订单详情
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 订单详情
     */
    OrderExt selectUserOdDetail(long userId, long orderId);
}