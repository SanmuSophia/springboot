package gcyl.entity.service.goods.impl;

import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.service.goods.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

/**
 * @author lican
 * @date 2018/9/7
 */
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public String test() {
        return orderMapper.selectByPrimaryKey(1000L).getOrderId().toString();
    }

    @Override
    public String testRedis() {
        return null;
    }
}
