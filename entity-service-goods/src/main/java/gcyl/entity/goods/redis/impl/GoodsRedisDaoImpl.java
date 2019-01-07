package gcyl.entity.goods.redis.impl;

import gcyl.entity.goods.redis.IGoodsRedisDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * 商品redis
 *
 * @author lican
 * @date 2018/12/14
 */
@Slf4j
@Component
public class GoodsRedisDaoImpl implements IGoodsRedisDao {

    @Autowired
    JedisPool jedisPool;

    @Override
    public boolean lock(String lockKey, int timeOut) {
        boolean lock = false;
        try (Jedis jedis = jedisPool.getResource()) {
            Long nx = jedis.setnx(lockKey, "1");
            lock = nx != null && nx == 1;
            if (lock) {
                jedis.expire(lockKey, timeOut);
            }
        } catch (Exception e) {
            log.debug("redis异常:" + e);
        }
        return lock;
    }

    @Override
    public void unlock(String lockKey) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(lockKey);
        } catch (Exception e) {
            log.debug("redis异常:" + e);
        }
    }
}
