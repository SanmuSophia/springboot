package gcyl.entity.domain.mapper.ex;

import gcyl.entity.domain.model.SpecValue;
import gcyl.entity.domain.model.SpecValueExample;

import java.util.List;

/**
 * specValue extend mapper
 *
 * @author lican
 * @date 2018/10/8
 */
public interface SpecValueExtMapper {
    List<SpecValue> selectByExample(SpecValueExample example);
}