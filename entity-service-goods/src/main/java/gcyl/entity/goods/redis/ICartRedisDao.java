package gcyl.entity.goods.redis;

import gcyl.entity.domain.model.form.CartForm;

import java.util.List;

/**
 * 购物车redis
 *
 * @author lican
 * @date 2018/12/24
 */
public interface ICartRedisDao {

    /**
     * 获取餐桌购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return  购物车商品列表
     */
    List<CartForm> getTable(long shopId, long tableNum);

    /**
     * 添加餐桌购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param num       商品数量
     * @param cartForm  商品参数
     * @return  大于0添加成功
     */
    long addTable(long shopId, long tableNum, int num, CartForm cartForm);

    /**
     * 餐桌商品移除/减少
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param specId    商品规格ID
     * @param num       商品数量
     * @return  大于0移除成功
     */
    long removeTable(long shopId, long tableNum, long specId, int num);

    /**
     * 清空购物车
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return 大于0清空成功
     */
    long clear(long shopId, long tableNum);

    /**
     * 获取用户购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @return  购物车商品列表
     */
//    List<CartForm> getUser(long shopId, long tableNum, long userId);

    /**
     * 添加个人购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @param num       商品数量
     * @param cartForm  商品参数
     * @return  大于0添加成功
     */
//    long addUser(long shopId, long tableNum, long userId, int num, CartForm cartForm);

    /**
     * 个人商品移除/减少
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @param specId    商品规格ID
     * @param num       商品数量
     * @return  大于0移除成功
     */
//    long removeUser(long shopId, long tableNum, long userId, long specId, int num);

    /**
     * 清空个人购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @return  大于0清空成功
     */
//    long clearUser(long shopId, long tableNum, long userId);
}
