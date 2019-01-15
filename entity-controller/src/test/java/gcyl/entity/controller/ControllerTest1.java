package gcyl.entity.controller;

import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.domain.mapper.ex.CategoryExtMapper;
import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.mapper.ex.OrderExtMapper;
import gcyl.entity.order.service.IOrderShopService;
import gcyl.entity.order.service.IOrderUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
    OrderExtMapper orderExtMapper;
    @Autowired
    IOrderShopService orderShopService;
    @Autowired
    IOrderUserService orderUserService;
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

    private int stock;
    @Test
    public void test() {
        List<Lambda> lambdas = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            lambdas.add(new Lambda(1));
        }
        long start = System.currentTimeMillis();
        lambdas.forEach(l -> stock += l.getNum());
        long end = System.currentTimeMillis();
        System.out.println(stock);
        System.out.println(end - start);
    }

    class Lambda {
        private Integer num;

        public Lambda(Integer num) {
            this.num = num;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }

    @Test
    public void testNum() {
//        System.out.println(orderShopService.orderNum(1));
//        System.out.println(orderUserService.orderNum(1));
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(DateUtils.getGmtDate());
        System.out.println(DateUtils.getDateTime());
    }
}
