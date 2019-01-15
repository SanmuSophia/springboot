package gcyl.entity.domain.mapper.ex;

import gcyl.entity.domain.model.Goods;
import gcyl.entity.domain.model.ex.GoodsEx;

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
    List<GoodsEx> selectByMap(Map<String, Object> paramMap);

    /**
     * 查询商品详情
     * @param id 商品主键
     * @return 商品详情
     */
    GoodsEx selectGoodsDetail(long id);

    /**
     * 更新商品月售
     * @param gmtModify  当前时间
     */
    int resetMonthSales(long gmtModify);

    /**
     * 增加商品销量
     *
     * @param list  商品销量信息
     */
    int batchAddSales(List<Map<String, Object>> list);
}