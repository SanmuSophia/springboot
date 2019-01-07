package gcyl.entity.controller.order;

import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.ex.OrderEx;
import gcyl.entity.domain.model.vo.OrderSNumVO;
import gcyl.entity.order.request.OrderSListRequest;
import gcyl.entity.order.service.IOrderShopService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 店铺订单管理
 *
 * @author lican
 * @date 2019/1/3
 */
@Controller
@RequestMapping("/order/shop")
public class OrderShopController {

    @Autowired
    IOrderShopService orderShopService;

    /**
     * 获取订单数量
     *
     * @param shopId  店铺ID
     */
    @ShopLogin
    @RequestMapping("/orderNum")
    @ResponseBody
    public Result orderNum(Long shopId) {
        Result result = new Result();
        if (shopId == null) {
            result.error("店铺信息有误");
            return result;
        }

        OrderSNumVO orderSNumVO = orderShopService.orderNum(shopId);

        result.success(orderSNumVO);
        return result;
    }

    /**
     * 订单列表
     */
    @ShopLogin
    @RequestMapping("/orderList")
    @ResponseBody
    public Result orderList(@Valid @RequestBody OrderSListRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        List<OrderEx> orderList = orderShopService.orderList(request);

        result.success(orderList);
        return result;
    }

    /**
     * 店铺订单详情
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    @ShopLogin
    @RequestMapping("/orderDetail")
    @ResponseBody
    public Result orderDetail(Long shopId, Long orderId) {
        Result result = new Result();
        if (shopId == null) {
            result.error("店铺信息有误");
            return result;
        }
        if (orderId == null) {
            result.error("订单信息有误");
            return result;
        }

        OrderEx orderEx = orderShopService.orderDetail(shopId, orderId);

        if (orderEx == null) {
            result.error(ResultEnum.O0003);
            return result;
        }

        result.success(orderEx);
        return result;
    }

    /**
     * 拒绝接单
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @param reason   拒接原因
     */
    @ShopLogin
    @RequestMapping("/refuse")
    @ResponseBody
    public Result refuse(Long shopId, Long orderId, String reason) {
        Result result = new Result();
        if (shopId == null) {
            result.error("店铺信息有误");
            return result;
        }
        if (orderId == null) {
            result.error("订单信息有误");
            return result;
        }
        if (StringUtils.isBlank(reason)) {
            result.error("请选择拒接原因");
            return result;
        }

        return orderShopService.refuse(shopId, orderId, reason);
    }

    /**
     * 接单
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    @ShopLogin
    @RequestMapping("/receive")
    @ResponseBody
    public Result receive(Long shopId, Long orderId) {
        Result result = new Result();
        if (shopId == null) {
            result.error("店铺信息有误");
            return result;
        }
        if (orderId == null) {
            result.error("订单信息有误");
            return result;
        }

        return orderShopService.receive(shopId, orderId);
    }

    /**
     * 上菜完成
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    @ShopLogin
    @RequestMapping("/finishServing")
    @ResponseBody
    public Result finishServing(Long shopId, Long orderId) {
        Result result = new Result();
        if (shopId == null) {
            result.error("店铺信息有误");
            return result;
        }
        if (orderId == null) {
            result.error("订单信息有误");
            return result;
        }

        return orderShopService.finishServing(shopId, orderId);
    }

    /**
     * 确认收款
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     */
    @ShopLogin
    @RequestMapping("/confirmReceipt")
    @ResponseBody
    public Result confirmReceipt(Long shopId, Long orderId) {
        Result result = new Result();
        if (shopId == null) {
            result.error("店铺信息有误");
            return result;
        }
        if (orderId == null) {
            result.error("订单信息有误");
            return result;
        }

        return orderShopService.confirmReceipt(shopId, orderId);
    }
}
