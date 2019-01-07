package gcyl.entity.goods.service.impl;

import gcyl.entity.common.enums.CutOffEnum;
import gcyl.entity.domain.mapper.ex.SpecKeyExtMapper;
import gcyl.entity.domain.mapper.ex.SpecValueExtMapper;
import gcyl.entity.domain.model.SpecKey;
import gcyl.entity.domain.model.SpecKeyExample;
import gcyl.entity.domain.model.SpecValue;
import gcyl.entity.domain.model.SpecValueExample;
import gcyl.entity.goods.service.ISpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 规格查询
 *
 * @author lican
 * @date 2018/12/17
 */
@Service
public class SpecServiceImpl implements ISpecService {

    @Autowired
    SpecKeyExtMapper specKeyExtMapper;
    @Autowired
    SpecValueExtMapper specValueExtMapper;

    /**
     * 获取所有规格类型
     * @return 规格类型集合
     */
    @Override
    public List<SpecKey> specKeys() {
        SpecKeyExample example = new SpecKeyExample();
        example.createCriteria()
                .andCutOffEqualTo(CutOffEnum.FALSE.getCode());
        return specKeyExtMapper.selectByExample(example);
    }


    /**
     * 获取规格类型的所有值
     * @param keyId  类型ID
     * @return       所有值
     */
    @Override
    public List<SpecValue> specValues(long keyId) {
        SpecValueExample example = new SpecValueExample();
        example.createCriteria()
                .andKeyIdEqualTo(keyId)
                .andCutOffEqualTo(CutOffEnum.FALSE.getCode());
        return specValueExtMapper.selectByExample(example);
    }
}
