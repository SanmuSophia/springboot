package gcyl.entity.category.service.impl;

import gcyl.entity.category.service.ICategorySearchService;
import gcyl.entity.common.enums.CutOffEnum;
import gcyl.entity.domain.mapper.GoodsMapper;
import gcyl.entity.domain.mapper.ex.CategoryExtMapper;
import gcyl.entity.domain.model.Category;
import gcyl.entity.domain.model.CategoryExample;
import gcyl.entity.domain.model.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @TODO 增加redis缓存
 *
 * @author lican
 * @date 2018/12/13
 */
@Service
public class CategorySearchService implements ICategorySearchService {

    @Autowired
    CategoryExtMapper categoryExtMapper;
    @Autowired
    GoodsMapper goodsMapper;

    /**
     * 获取店铺类目集合
     * @param shopId  店铺ID
     * @return 店铺类目集合
     */
    @Override
    public List<Category> getShopCategory(long shopId) {
        CategoryExample example = new CategoryExample();
        example.createCriteria()
                .andShopIdEqualTo(shopId)
                .andCutOffEqualTo(CutOffEnum.FALSE.getCode());
        return categoryExtMapper.selectByExample(example);
    }

    /**
     * 判断是否有默认分类
     * @param shopId 店铺ID
     * @return true 有默认分类
     */
    @Override
    public boolean hasDefault(long shopId) {
        GoodsExample example = new GoodsExample();
        example.createCriteria()
                .andShopIdEqualTo(shopId)
                .andIsDefaultEqualTo(true)
                .andCutOffEqualTo(CutOffEnum.FALSE.getCode());
        return goodsMapper.countByExample(example) > 0;
    }
}
