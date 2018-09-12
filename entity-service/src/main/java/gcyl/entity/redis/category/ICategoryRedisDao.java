package gcyl.entity.redis.category;

import gcyl.entity.domain.model.Category;

/**
 * 类目redis
 *
 * @author lican
 * @date 2018/9/11
 */
public interface ICategoryRedisDao {

    /**
     * 增加店铺类目
     *
     * @param category 类目信息
     */
    void addShopCategory(Category category);
}
