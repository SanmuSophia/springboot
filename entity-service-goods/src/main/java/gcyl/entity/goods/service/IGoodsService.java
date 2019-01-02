package gcyl.entity.goods.service;

import gcyl.entity.common.result.Result;
import gcyl.entity.goods.request.GoodsAddRequest;
import gcyl.entity.goods.request.GoodsStateUpRequest;
import gcyl.entity.goods.request.GoodsUpRequest;

import java.util.List;

/**
 * 商品管理
 * 1.店铺修改商品操作where条件带上shopId,
 * 防止在店铺和商品信息不一致的情况的被修改
 *
 * @author lican
 * @date 2018/12/12
 */
public interface IGoodsService {

    /**
     * 商品添加
     *
     * @param request 商品参数
     * @return 添加结果
     */
    Result add(GoodsAddRequest request);

    /**
     * 商品状态修改
     * 加入店长推荐、默认商品、商品在售
     *
     * @param request 修改参数
     * @return 修改结果
     */
    Result upState(GoodsStateUpRequest request);

    /**
     * 商品修改
     *
     * @param request 修改参数
     * @return 修改结果
     */
    Result update(GoodsUpRequest request);

    /**
     * 商品删除
     *
     * @param shopId    店铺ID
     * @param goodsIds  商品ID集合
     * @return 删除结果
     */
    Result delete(long shopId, List<Long> goodsIds);

    /**
     * 商品下架
     *
     * @param shopId    店铺ID
     * @param goodsIds  商品ID集合
     * @return 下架结果
     */
    Result offShelve(long shopId, List<Long> goodsIds);

    /**
     * 商品上架
     *
     * @param shopId    店铺ID
     * @param goodsIds  商品ID集合
     * @return 上架结果
     */
    Result onShelve(long shopId, List<Long> goodsIds);

    /**
     * 恢复库存
     *
     * @param shopId   店铺ID
     * @param goodsId  商品ID
     * @return
     */
    Result restock(long shopId, long goodsId);
}
