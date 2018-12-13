package gcyl.entity.controller;

import gcyl.entity.domain.mapper.my.CategoryExtMapper;
import gcyl.entity.domain.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lican
 * @date 2018/9/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest1 {

    @Test1(1)
    private Integer intValue;

    @Autowired
    CategoryExtMapper categoryExtMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    RedisTemplate<String, Object> template;

    @Test
    public void contextLoads() {
        System.out.println(orderMapper.selectByPrimaryKey(1000L));
    }

    @Test
    public void testRedis() {
        template.opsForValue().set("key", "value");
    }

    @Test
    public void test() {
        System.out.println();
    }
}
