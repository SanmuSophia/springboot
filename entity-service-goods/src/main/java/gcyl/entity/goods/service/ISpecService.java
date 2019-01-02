package gcyl.entity.goods.service;

import gcyl.entity.domain.model.SpecKey;
import gcyl.entity.domain.model.SpecValue;

import java.util.List;

/**
 * 规格查询
 *
 * @author lican
 * @date 2018/12/17
 */
public interface ISpecService {

    /**
     * 获取所有规格类型
     * @return 规格类型集合
     */
    List<SpecKey> getSpecKeys();

    /**
     * 获取规格类型的所有值
     * @param keyId  类型ID
     * @return       所有值
     */
    List<SpecValue> getSpecValues(long keyId);
}
