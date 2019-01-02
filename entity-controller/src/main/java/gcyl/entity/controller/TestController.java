package gcyl.entity.controller;

import gcyl.entity.common.utils.IpContext;
import gcyl.entity.request.TestRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    JedisPool jedisPool;
    public static String str = "1";

//    @UserLogin
    @ResponseBody
    @ApiOperation(value = "get测试")
    @RequestMapping(value = "/controller", method = RequestMethod.GET)
    public String getTest(String goods) {
        return IpContext.getUserIp();
    }

    @ResponseBody
    @ApiOperation(value = "post测试")
    @RequestMapping(value = "/controller", method = RequestMethod.POST)
    public String postTest(@RequestBody TestRequest request) {
        return request.getGoodsId();
    }
}
