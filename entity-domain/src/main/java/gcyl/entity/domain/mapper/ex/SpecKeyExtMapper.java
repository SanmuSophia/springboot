package gcyl.entity.domain.mapper.ex;

import gcyl.entity.domain.model.SpecKey;
import gcyl.entity.domain.model.SpecKeyExample;

import java.util.List;

/**
 * specKey extend mapper
 *
 * @author lican
 * @date 2018/10/8
 */
public interface SpecKeyExtMapper {
    List<SpecKey> selectByExample(SpecKeyExample example);
}