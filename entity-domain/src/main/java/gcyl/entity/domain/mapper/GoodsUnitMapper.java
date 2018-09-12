package gcyl.entity.domain.mapper;

import gcyl.entity.domain.model.GoodsUnit;
import gcyl.entity.domain.model.GoodsUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsUnitMapper {
    int countByExample(GoodsUnitExample example);

    int deleteByExample(GoodsUnitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsUnit record);

    int insertSelective(GoodsUnit record);

    List<GoodsUnit> selectByExample(GoodsUnitExample example);

    GoodsUnit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsUnit record, @Param("example") GoodsUnitExample example);

    int updateByExample(@Param("record") GoodsUnit record, @Param("example") GoodsUnitExample example);

    int updateByPrimaryKeySelective(GoodsUnit record);

    int updateByPrimaryKey(GoodsUnit record);
}