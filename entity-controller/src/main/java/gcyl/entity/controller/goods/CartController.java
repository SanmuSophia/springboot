package gcyl.entity.controller.goods;

import gcyl.entity.common.constant.Message;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.request.*;
import gcyl.entity.goods.service.ICartService;
import gcyl.entity.goods.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * 购物车管理
 *
 * @author lican
 * @date 2019/1/3
 */
@RestController
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
    @GetMapping(value = "/get")
    public Result get(Long shopId, Long tableNum) {
        Result result = new Result();
        if (shopId == null) {
            result.error(Message.SHOP_ID_NULL);
            return result;
        }
        if (tableNum == null) {
            result.error(Message.TABLE_NUM_NULL);
            return result;
        }

        List<CartForm> cartForms = cartService.get(shopId, tableNum);
        List<CartForm> defaults = cartService.getDefault(shopId);

        Map<String, List<CartForm>> cartMap = this.list2MapByCategory(cartForms);
        Map<String, List<CartForm>> defaultMap = this.list2MapByCategory(defaults);

        CartVO cartVO = new CartVO();
        cartVO.setCartMap(cartMap);
        cartVO.setDefaultMap(defaultMap);

        result.success(cartVO);
        return result;
    }

    /**
     * 添加购物车
     */
    @PostMapping(value = "/add")
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
    @PostMapping(value = "/remove")
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
    @PostMapping(value = "/clear")
    public Result clear(Long shopId, Long tableNum) {
        Result result = new Result();
        if (shopId == null) {
            result.error(Message.SHOP_ID_NULL);
            return result;
        }
        if (tableNum == null) {
            result.error(Message.TABLE_NUM_NULL);
            return result;
        }

        return cartService.clear(shopId, tableNum);
    }

    /**
     * 根据类目分组
     *
     * @param cartForms  商品集合
     * @return 分组后的map
     */
    private Map<String, List<CartForm>> list2MapByCategory(List<CartForm> cartForms) {
        //根据类目分组
        Map<String, List<CartForm>> cartMap  = new LinkedHashMap<>();
        for (CartForm cartForm : cartForms) {
            String categoryName = cartForm.getCategoryName();
            List<CartForm> list = cartMap.get(categoryName);
            if (list == null) {
                list = new ArrayList<>();
                list.add(cartForm);
                cartMap.put(categoryName, list);
            } else {
                list.add(cartForm);
            }
        }
        return cartMap;
    }
}
