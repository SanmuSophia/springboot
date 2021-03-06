package gcyl.entity.controller.order;

import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.constant.Message;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.ex.OrderEx;
import gcyl.entity.domain.model.vo.OrderUNumVO;
import gcyl.entity.order.request.OrderUListRequest;
import gcyl.entity.order.service.IOrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户订单管理
 *
 * @author lican
 * @date 2019/1/3
 */
@RestController
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
    @PostMapping(value = "/orderNum")
    public Result orderNum(Long userId) {
        Result result = new Result();
        if (userId == null) {
            result.error(Message.USER_ID_NULL);
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
    @PostMapping(value = "/orderList")
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
    @PostMapping(value = "/orderDetail")
    public Result orderDetail(Long userId, Long orderId) {
        Result result = new Result();
        if (userId == null) {
            result.error(Message.USER_ID_NULL);
            return result;
        }
        if (orderId == null) {
            result.error(Message.ORDER_ID_NULL);
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
