package gcyl.entity.controller.goods;

import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.result.Result;
import gcyl.entity.goods.form.SpecAddForm;
import gcyl.entity.goods.form.SpecUpForm;
import gcyl.entity.goods.request.*;
import gcyl.entity.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 商品管理
 *
 * @author lican
 * @date 2019/1/3
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    IGoodsService goodsService;

    /**
     * 新增
     *
     * @param request        新增参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@Valid @RequestBody GoodsAddRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }
        result = this.validateAdd(request);
        if (!result.isSuccess()) return result;

        return goodsService.add(request);
    }

    /**
     * 修改商品状态
     *
     * @param request        修改参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @RequestMapping(value = "/upState", method = RequestMethod.POST)
    @ResponseBody
    public Result upState(@Valid @RequestBody GoodsStateUpRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return goodsService.upState(request);
    }

    /**
     * 修改
     *
     * @param request        修改参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@Valid @RequestBody GoodsUpRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }
        result = this.validateUpdate(request);
        if (!result.isSuccess()) return result;


        return goodsService.update(request);
    }

    /**
     * 删除
     *
     * @param request        删除参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@Valid @RequestBody BatchUpRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return goodsService.delete(request.getShopId(), request.getGoodsIds());
    }

    /**
     * 商品下架
     *
     * @param request        下架参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @RequestMapping(value = "/offShelve", method = RequestMethod.POST)
    @ResponseBody
    public Result offShelve(@Valid @RequestBody BatchUpRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return goodsService.offShelve(request.getShopId(), request.getGoodsIds());
    }

    /**
     * 商品上架
     *
     * @param request        上架参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @RequestMapping(value = "/onShelve", method = RequestMethod.POST)
    @ResponseBody
    public Result onShelve(@Valid @RequestBody BatchUpRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return goodsService.onShelve(request.getShopId(), request.getGoodsIds());
    }

    /**
     * 库存恢复
     *
     * @param request        上架参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @RequestMapping(value = "/restock", method = RequestMethod.POST)
    @ResponseBody
    public Result restock(@Valid @RequestBody RestockRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return goodsService.restock(request.getShopId(), request.getGoodsId());
    }


    /**
     * 商品新增参数验证
     */
    private Result validateAdd(GoodsAddRequest request) {
        Result result = new Result();
        List<SpecAddForm> specAddForms = request.getSpecAddForms();
        Set<String> keys = new HashSet<>();
        Set<String> names = new HashSet<>();
        for (SpecAddForm form : specAddForms) {
            keys.add(form.getSpecKey());
            names.add(form.getSpecName());
        }
        if (keys.size() > 1) {
            result.error("只能选择一种规格");
            return result;
        }
        if (names.size() < specAddForms.size()) {
            result.error("规格重复");
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 商品修改参数验证
     */
    private Result validateUpdate(GoodsUpRequest request) {
        Result result = new Result();
        List<SpecUpForm> specAddForms = request.getSpecUpForms();
        Set<String> keys = new HashSet<>();
        Set<String> names = new HashSet<>();
        for (SpecUpForm form : specAddForms) {
            keys.add(form.getSpecKey());
            names.add(form.getSpecName());
        }
        if (keys.size() > 1) {
            result.error("只能选择一种规格");
            return result;
        }
        if (names.size() < specAddForms.size()) {
            result.error("规格重复");
            return result;
        }

        result.success();
        return result;
    }
}
