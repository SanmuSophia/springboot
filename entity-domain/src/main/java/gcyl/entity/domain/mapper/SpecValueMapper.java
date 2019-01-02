package gcyl.entity.domain.mapper;

import gcyl.entity.domain.model.SpecValue;
import gcyl.entity.domain.model.SpecValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecValueMapper {
    int countByExample(SpecValueExample example);

    int deleteByExample(SpecValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpecValue record);

    int insertSelective(SpecValue record);

    List<SpecValue> selectByExample(SpecValueExample example);

    SpecValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpecValue record, @Param("example") SpecValueExample example);

    int updateByExample(@Param("record") SpecValue record, @Param("example") SpecValueExample example);

    int updateByPrimaryKeySelective(SpecValue record);

    int updateByPrimaryKey(SpecValue record);
}