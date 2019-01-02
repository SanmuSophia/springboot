package gcyl.entity.goods.redis.impl;

import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.goods.redis.IGoodsRedisDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 商品redis
 *
 * @author lican
 * @date 2018/12/14
 */
@Component
public class GoodsRedisDaoImpl implements IGoodsRedisDao {

}
