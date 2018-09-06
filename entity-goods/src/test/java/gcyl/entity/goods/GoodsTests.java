package gcyl.entity.goods;

import gcyl.entity.domain.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTests {
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	RedisTemplate<String, String> template;

	@Test
	public void contextLoads() {
        System.out.println(orderMapper.selectByPrimaryKey(1000L));
	}

	@Test
	public void testRedis() {
		template.opsForValue().set("key", "value");
	}
}
