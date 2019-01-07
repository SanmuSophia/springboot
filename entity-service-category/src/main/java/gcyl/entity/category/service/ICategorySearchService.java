package gcyl.entity.category.service;

import gcyl.entity.domain.model.Category;

import java.util.List;

/**
 * 类目搜索
 *
 * @author lican
 * @date 2018/12/13
 */
public interface ICategorySearchService {

    /**
     * 获取店铺类目集合
     * @param shopId  店铺ID
     * @return 店铺类目集合
     */
    List<Category> getShopCategory(long shopId);

    /**
     * 判断是否有默认分类
     * @param shopId 店铺ID
     * @return true 有默认分类
     */
    boolean hasDefault(long shopId);
}
