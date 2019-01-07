package gcyl.entity.goods.service.impl;

import gcyl.entity.common.enums.CutOffEnum;
import gcyl.entity.common.enums.UnitEnum;
import gcyl.entity.domain.mapper.ex.UnitExtMapper;
import gcyl.entity.domain.model.Unit;
import gcyl.entity.domain.model.UnitExample;
import gcyl.entity.goods.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lican
 * @date 2018/12/18
 */
@Service
public class UnitServiceImpl implements IUnitService {

    @Autowired
    UnitExtMapper unitExtMapper;

    /**
     * 获取所有单位
     * @return 所有单位
     */
    @Override
    public List<Unit> units() {
        UnitExample example = new UnitExample();
        example.createCriteria()
                .andUnitTypeEqualTo(UnitEnum.MS.getCode())
                .andCutOffEqualTo(CutOffEnum.FALSE.getCode());
        return unitExtMapper.selectByExample(example);
    }
}
