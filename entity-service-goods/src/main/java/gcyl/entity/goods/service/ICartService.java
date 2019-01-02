package gcyl.entity.goods.service;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.request.CartRequest;

import java.util.List;

/**
 * 购物车管理
 *
 * @author lican
 * @date 2018/12/24
 */
public interface ICartService {

    /**
     * 获取用户购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @return  购物车商品列表
     */
    List<CartForm> getUser(long shopId, long tableNum, long userId);

    /**
     * 获取餐桌购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return  购物车商品列表
     */
    List<CartForm> getTable(long shopId, long tableNum);

    /**
     * 添加商品
     *
     * @param request  商品参数
     * @return  添加结果
     */
    Result add(CartRequest request);

    /**
     * 商品移除
     *
     * @param request  商品参数
     * @return  添加结果
     */
    Result removeUser(CartRequest request);

    /**
     * 清空个人购物车
     *
     * @param request  商品参数
     * @return  添加结果
     */
    Result clearUser(CartRequest request);
}
