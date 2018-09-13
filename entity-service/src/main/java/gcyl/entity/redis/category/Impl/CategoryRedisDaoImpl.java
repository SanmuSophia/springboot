package gcyl.entity.redis.category.Impl;

import gcyl.entity.domain.model.Category;
import gcyl.entity.redis.category.ICategoryRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 类目redis
 *
 * @author lican
 * @date 2018/9/11
 */
@Component
public class CategoryRedisDaoImpl implements ICategoryRedisDao {

    @Autowired
    RedisTemplate<String, String> template;
//    @Autowired
//    JedisPool jedisPool;
    /**
     * 增加店铺类目
     *
     * @param category 类目信息
     */
    @Override
    public void addShopCategory(Category category) {
    }
}
