package gcyl.entity.domain.mapper.ex;

import gcyl.entity.domain.model.Unit;
import gcyl.entity.domain.model.UnitExample;

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