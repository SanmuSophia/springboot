package gcyl.entity.goods.service.impl;

import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.model.Order;
import gcyl.entity.goods.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author lican
 * @date 2018/9/5
 */
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    RedisTemplate<String, String> stringTemplate;
    @Autowired
    OrderMapper orderMapper;

    public String test() {
        return orderMapper.selectByPrimaryKey(1000L).toString();
    }
}
