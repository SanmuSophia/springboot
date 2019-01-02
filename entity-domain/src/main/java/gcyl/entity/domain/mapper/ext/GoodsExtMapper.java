package gcyl.entity.domain.mapper.ext;

import gcyl.entity.domain.model.Goods;
import gcyl.entity.domain.model.ext.GoodsExt;

import java.util.List;
import java.util.Map;

/**
 * goods extend mapper
 *
 * @author lican
 * @date 2018/10/8
 */
public interface GoodsExtMapper {
    /**
     * 插入并填充主键
     * @param goods 商品信息
     */
    int insertSelective(Goods goods);

    /**
     * 商品搜索
     * @param paramMap 搜索条件
     * @return 满足条件商品
     */
    List<GoodsExt> selectByMap(Map<String, Object> paramMap);

    /**
     * 查询商品详情
     * @param id 商品主键
     * @return 商品详情
     */
    GoodsExt selectGoodsDetail(long id);
}