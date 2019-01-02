package gcyl.entity.domain.mapper;

import gcyl.entity.domain.model.SpecKey;
import gcyl.entity.domain.model.SpecKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecKeyMapper {
    int countByExample(SpecKeyExample example);

    int deleteByExample(SpecKeyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpecKey record);

    int insertSelective(SpecKey record);

    List<SpecKey> selectByExample(SpecKeyExample example);

    SpecKey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpecKey record, @Param("example") SpecKeyExample example);

    int updateByExample(@Param("record") SpecKey record, @Param("example") SpecKeyExample example);

    int updateByPrimaryKeySelective(SpecKey record);

    int updateByPrimaryKey(SpecKey record);
}