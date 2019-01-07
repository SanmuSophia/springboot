package gcyl.entity.controller.goods;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.request.*;
import gcyl.entity.goods.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 购物车管理
 *
 * @author lican
 * @date 2019/1/3
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService cartService;

    /**
     * 获取购物车列表
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public Result get(Long shopId, Long tableNum) {
        Result result = new Result();
        if (shopId == null) {
            result.error("店铺信息有误");
            return result;
        }
        if (tableNum == null) {
            result.error("餐桌信息有误");
            return result;
        }

        List<CartForm> cartForms = cartService.get(shopId, tableNum);
        result.success(cartForms);
        return result;
    }

    /**
     * 添加购物车
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@Valid @RequestBody CartAddRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return cartService.add(request);
    }

    /**
     * 移除购物车
     */
    @RequestMapping("/remove")
    @ResponseBody
    public Result remove(@Valid @RequestBody CartDelRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return cartService.remove(request);
    }

    /**
     * 清空购物车
     */
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ResponseBody
    public Result clear(Long shopId, Long tableNum) {
        Result result = new Result();
        if (shopId == null) {
            result.error("店铺信息有误");
            return result;
        }
        if (tableNum == null) {
            result.error("餐桌信息有误");
            return result;
        }

        return cartService.clear(shopId, tableNum);
    }
}
