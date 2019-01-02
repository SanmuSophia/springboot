package gcyl.entity.goods.service;

import gcyl.entity.domain.model.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品单位
 *
 * @author lican
 * @date 2018/12/18
 */
public interface IUnitService {

    /**
     * 获取所有单位
     * @return 所有单位
     */
    List<Unit> getUnits();
}
