package gcyl.entity.controller.order;

import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.ex.OrderEx;
import gcyl.entity.domain.model.vo.OrderUNumVO;
import gcyl.entity.order.request.OrderUListRequest;
import gcyl.entity.order.service.IOrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户订单管理
 *
 * @author lican
 * @date 2019/1/3
 */
@Controller
@RequestMapping("/order/user")
public class OrderUserController {

    @Autowired
    IOrderUserService orderUserService;

    /**
     * 获取订单数量
     *
     * @param userId  用户ID
     */
    @ShopLogin
    @RequestMapping("/orderNum")
    @ResponseBody
    public Result orderNum(Long userId) {
        Result result = new Result();
        if (userId == null) {
            result.error("用户信息有误");
            return result;
        }

        OrderUNumVO orderUNumVO = orderUserService.orderNum(userId);

        result.success(orderUNumVO);
        return result;
    }

    /**
     * 订单列表
     */
    @ShopLogin
    @RequestMapping("/orderList")
    @ResponseBody
    public Result orderList(@Valid @RequestBody OrderUListRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        List<OrderEx> orderList = orderUserService.orderList(request);

        result.success(orderList);
        return result;
    }

    /**
     * 订单详情
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     */
    @ShopLogin
    @RequestMapping("/orderDetail")
    @ResponseBody
    public Result orderDetail(Long userId, Long orderId) {
        Result result = new Result();
        if (userId == null) {
            result.error("用户信息有误");
            return result;
        }
        if (orderId == null) {
            result.error("订单信息有误");
            return result;
        }

        OrderEx orderEx = orderUserService.orderDetail(userId, orderId);

        if (orderEx == null) {
            result.error(ResultEnum.O0004);
            return result;
        }

        result.success(orderEx);
        return result;
    }
}
