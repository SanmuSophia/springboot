package gcyl.entity.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lican
 * @date 2018/9/4
 */
@RestController
public class TestController {

    @RequestMapping("/order")
    public String test() {
        return "order";
    }
}
