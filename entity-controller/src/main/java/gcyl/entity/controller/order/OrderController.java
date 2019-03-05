package gcyl.entity.controller.order;

import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.enums.order.PayWayEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.goods.service.ICartService;
import gcyl.entity.order.request.OrderCreateRequest;
import gcyl.entity.order.request.OrderPaidRequest;
import gcyl.entity.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * 订单管理
 *
 * @author lican
 * @date 2019/1/3
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    IOrderService orderService;
    @Autowired
    ICartService cartService;

    /**
     * 创建订单
     *
     * @param request        创建参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @PostMapping(value = "/create")
    public Result create(@Valid @RequestBody OrderCreateRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        result = this.validate(request);
        if (!result.isSuccess()) return result;


        return orderService.create(request);
    }

    /**
     * 商品新增参数验证
     */
    private Result validate(OrderCreateRequest request) {
        Result result = new Result();
        BigDecimal deductAmount = request.getDeductAmount();
        BigDecimal goodsAmount = request.getGoodsAmount();
        if (deductAmount.compareTo(goodsAmount) > 0) {
            result.error("抵扣金额超出商品金额");
            return result;
        }

        int payWay = request.getPayWay();
        PayWayEnum payWayEnum = PayWayEnum.getEnumByCode(payWay);
        if (payWayEnum == null) {
            result.error("支付方式异常");
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 订单支付完成
     *
     * @param request        创建参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @PostMapping(value = "/paid")
    public Result paid(@Valid @RequestBody OrderPaidRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return orderService.paid(request);
    }
}
