package gcyl.entity.domain.mapper.ex;

import gcyl.entity.domain.model.Order;
import gcyl.entity.domain.model.ex.OrderEx;
import gcyl.entity.domain.model.form.OrderGoodsForm;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrderExtMapper {

    int insertSelective(Order record);

    /**
     * 计算订单数量
     *
     * @param paramMap  查询条件
     * @return 订单数量
     */
    int countByMap(Map<String, Object> paramMap);

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
    List<OrderEx> selectShopOdList(Map<String, Object> paramMap);

    /**
     * 获取店铺订单详情
     *
     * @param paramMap  shopId,orderId
     * @return 订单详情
     */
    OrderEx selectShopOdDetail(Map<String, Object> paramMap);

    /**
     * 根据条件搜索用户订单列表
     *
     * @param paramMap  搜索条件
     * @return 订单列表
     */
    List<OrderEx> selectUserOdList(Map<String, Object> paramMap);

    /**
     * 获取用户订单详情
     *
     * @param paramMap   userId,orderId
     * @return 订单详情
     */
    OrderEx selectUserOdDetail(Map<String, Object> paramMap);

    /**
     * 获取订单商品数量
     * @param orderId  订单ID
     * @return 订单商品数量
     */
    List<OrderGoodsForm> selectOrderGoodsNum(long orderId);

    /**
     * 获取订单支付状态
     *
     * @param orderId  订单ID
     * @return true 已支付
     */
    @Select("select is_pay " +
            "from tyg_ms_order " +
            "where id = #{orderId}")
    boolean selectIsPay(long orderId);
}