package gcyl.entity.controller.goods;

import gcyl.entity.controller.request.TestRequest;
import gcyl.entity.service.goods.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @author lican
 * @date 2018/9/4
 */
@RestController
@RequestMapping("/goods")
@Api(description = "商品接口")

public class TestController {

    @Autowired
    ITestService testService;
    @Autowired
    JedisPool jedisPool;

    @ResponseBody
    @ApiOperation(value = "get测试")
    @RequestMapping(value = "/controller", method = RequestMethod.GET)
    public void getTest(String goods) {
        Jedis jedis = jedisPool.getResource();
        jedis.sadd("key", "value");
        jedis.close();
    }

    @ResponseBody
    @ApiOperation(value = "post测试")
    @RequestMapping(value = "/controller", method = RequestMethod.POST)
    public String postTest(@RequestBody TestRequest request) {
        return request.getGoodsId();
    }
}
