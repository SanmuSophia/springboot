package gcyl.entity.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        long time1 = System.currentTimeMillis();
        String encodePass = encoder.encode("123456");
        long time2 = System.currentTimeMillis();
        System.out.println(encodePass);
        System.out.println(encoder.matches("123456", encodePass));
        long time3 = System.currentTimeMillis();
        System.out.println(time3 - time2);
        System.out.println(time2 - time1);
    }

    @Autowired
    AsyncDemo asyncDemo;
    @Test
    public void testAsync() throws ExecutionException, InterruptedException {
        Future<String> future = asyncDemo.asyncInvokeReturnFuture(2);
        asyncDemo.asyncInvokeSimplest();
        asyncDemo.asyncInvokeWithParameter("1");
        System.out.println(future.get());
    }
}
