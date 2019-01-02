package gcyl.entity.order.redis.impl;

import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.order.redis.IOrderRedisDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lican
 * @date 2018/12/27
 */
@Component
public class OrderRedisDaoImpl implements IOrderRedisDao {

}
