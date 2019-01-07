package gcyl.entity.goods.redis;

/**
 * 商品redis
 *
 * @author lican
 * @date 2018/12/14
 */
public interface IGoodsRedisDao {

    boolean lock(String lockKey, int timeOut);

    void unlock(String lockKey);
}
