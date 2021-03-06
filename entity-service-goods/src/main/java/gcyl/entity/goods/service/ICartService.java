package gcyl.entity.goods.service;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.request.CartAddRequest;
import gcyl.entity.goods.request.CartDelRequest;

import java.util.List;

/**
 * 购物车管理
 *
 * @author lican
 * @date 2018/12/24
 */
public interface ICartService {

    /**
     * 获取餐桌购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return  购物车商品列表
     */
    List<CartForm> get(long shopId, long tableNum);

    /**
     * 获取默认商品
     *
     * @param shopId    店铺ID
     * @return  默认商品
     */
    List<CartForm> getDefault(long shopId);

    /**
     * 添加商品
     *
     * @param request  商品参数
     */
    Result add(CartAddRequest request);

    /**
     * 商品移除
     *
     * @param request  商品参数
     */
    Result remove(CartDelRequest request);

    /**
     * 清空购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     */
    Result clear(long shopId, long tableNum);

//    /**
//     * 获取用户购物车
//     *
//     * @param shopId    店铺ID
//     * @param tableNum  桌号
//     * @param userId    用户ID
//     * @return  购物车商品列表
//     */
//    List<CartForm> getUser(long shopId, long tableNum, long userId);
}
