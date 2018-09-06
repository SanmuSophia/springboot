package gcyl.entity.goods.controller;

import gcyl.entity.goods.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lican
 * @date 2018/9/4
 */
@RestController
public class TestController {

    @Autowired
    ITestService testService;

    @RequestMapping("/goods")
    public String test() {
        return testService.test();
    }
}
