package gcyl.entity.domain.mapper.ext;

import gcyl.entity.domain.model.Unit;
import gcyl.entity.domain.model.UnitExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * unit extend mapper
 *
 * @author lican
 * @date 2018/10/8
 */
public interface UnitExtMapper {

    List<Unit> selectByExample(UnitExample example);
}