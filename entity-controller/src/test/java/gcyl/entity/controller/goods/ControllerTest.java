package gcyl.entity.controller.goods;

import gcyl.entity.domain.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lican
 * @date 2018/9/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

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
        System.out.println(template.getClass());
    }
}
