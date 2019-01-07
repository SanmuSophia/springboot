package gcyl.entity.controller.order;

import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.service.ICartService;
import gcyl.entity.order.form.SpecNumForm;
import gcyl.entity.order.request.OrderCreateRequest;
import gcyl.entity.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 订单管理
 *
 * @author lican
 * @date 2019/1/3
 */
@Controller
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
    @RequestMapping("/create")
    @ResponseBody
    public Result create(@Valid @RequestBody OrderCreateRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        result = this.validate(request);
        if (!result.isSuccess()) {
            return result;
        }

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

        //验证购物车列表是否发生变化
        List<CartForm> cartForms = cartService.get(request.getShopId(), request.getTableNum());
        List<SpecNumForm> specNumForms = request.getSpecNumForms();
        if (cartForms.size() != specNumForms.size()) {
            result.error("订单发生变化，请刷新");
            return result;
        }
        Set<String> all = new HashSet<>();
        Set<String> old = new HashSet<>();
        for (CartForm form : cartForms) {
            old.add(form.getSpecId() + ":" + form.getNum());
            all.add(form.getSpecId() + ":" + form.getNum());
        }
        Set<String> now = new HashSet<>();
        for (SpecNumForm form : specNumForms) {
            now.add(form.getSpecId() + ":" + form.getNum());
            all.add(form.getSpecId() + ":" + form.getNum());
        }

        if (all.size() != old.size() || all.size() != now.size()) {
            result.error("订单发生变化，请刷新");
            return result;
        }

        result.success();
        return result;
    }
}
