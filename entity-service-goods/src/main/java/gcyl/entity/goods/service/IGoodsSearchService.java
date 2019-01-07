package gcyl.entity.goods.service;

import gcyl.entity.domain.model.GoodsSpec;
import gcyl.entity.domain.model.ex.GoodsEx;
import gcyl.entity.goods.request.GoodsSearchRequest;

import java.util.List;

/**
 * 商品搜索
 *
 * @author lican
 * @date 2018/12/18
 */
public interface IGoodsSearchService {

    /**
     * 商品搜索搜索
     *
     * @param request 搜索参数
     * @return 列表商品
     */
    List<GoodsEx> goodsList(GoodsSearchRequest request);

    /**
     * 商品详情
     *
     * @param id 商品主键
     * @return 商品详情
     */
    GoodsEx goodsDetail(long id);

    /**
     * 获取商品所有规格
     *
     * @param goodsId 商品ID
     * @return 规格列表
     */
    List<GoodsSpec> goodsSpecList(long goodsId);
}
