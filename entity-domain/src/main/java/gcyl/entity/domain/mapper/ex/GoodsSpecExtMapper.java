package gcyl.entity.domain.mapper.ex;

import gcyl.entity.domain.model.GoodsSpec;
import gcyl.entity.domain.model.GoodsSpecExample;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * goodsSpec extend mapper
 *
 * @author lican
 * @date 2018/10/8
 */
public interface GoodsSpecExtMapper {

    List<GoodsSpec> selectByExample(GoodsSpecExample example);

    /**
     * 根据商品ID查询所有规格
     * 被GoodsExtMapper.selectGoodsDetail引用
     *
     * @param goodsId 商品ID
     * @return 所有商品规格
     */
    List<GoodsSpec> selectByGoodsId(long goodsId);

    /**
     * 查询规格库存
     *
     * @param specId 规格ID
     * @return 规格库存
     */
    @Select("select spec_day_stock " +
            "from tyg_ms_goods_spec " +
            "where id = #{specId} " +
            "and cut_off = false")
    Integer selectSpecStock(long specId);

    /**
     * 批量插入商品规格
     * @param list 商品规格集合
     */
    int batchInsert(List<GoodsSpec> list);

    /**
     * 批量修改商品规格
     * @param list 商品规格集合
     */
    int batchUpdate(List<GoodsSpec> list);

    /**
     * 恢复商品日库存
     * @param goodsSpec 商品ID
     */
    int restockByGoods(GoodsSpec goodsSpec);

    /**
     * 恢复所有商品日库存
     * @param gmtModify  当前时间
     */
    int restock(long gmtModify);

    /**
     * 查询商品所有规格ID
     * @param goodsId 商品ID
     * @return 规格ID集合
     */
    @Select("select id " +
            "from tyg_ms_goods_spec " +
            "where goods_id = #{goodsId} " +
            "and cut_off = false")
    List<Long> selectSpecIds(long goodsId);
}