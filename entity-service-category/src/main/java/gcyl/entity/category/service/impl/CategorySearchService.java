package gcyl.entity.category.service.impl;

import gcyl.entity.category.service.ICategorySearchService;
import gcyl.entity.common.enums.CutOffEnum;
import gcyl.entity.domain.mapper.my.CategoryExtMapper;
import gcyl.entity.domain.model.Category;
import gcyl.entity.domain.model.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lican
 * @date 2018/12/13
 */
@Service
public class CategorySearchService implements ICategorySearchService {

    @Autowired
    CategoryExtMapper categoryExtMapper;

    /**
     * 获取店铺类目集合
     * @param shopId  店铺ID
     * @return 店铺类目集合
     */
    @Override
    public List<Category> getCategoryByShop(long shopId) {
        CategoryExample example = new CategoryExample();
        example.createCriteria()
                .andShopIdEqualTo(shopId)
                .andCutOffEqualTo(CutOffEnum.FALSE.getCode());
        return categoryExtMapper.selectByExample(example);
    }
}
