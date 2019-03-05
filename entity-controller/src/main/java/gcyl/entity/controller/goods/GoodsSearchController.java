package gcyl.entity.controller.goods;

import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.constant.Message;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.GoodsSpec;
import gcyl.entity.domain.model.ex.GoodsEx;
import gcyl.entity.goods.request.*;
import gcyl.entity.goods.service.IGoodsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * 商品搜索
 *
 * @author lican
 * @date 2019/1/3
 */
@RestController
@RequestMapping("/goodsSearch")
public class GoodsSearchController {

    @Autowired
    IGoodsSearchService goodsSearchService;

    /**
     * 商品列表
     *
     * @param request        新增参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @PostMapping(value = "/goodsList")
    public Result goodsList(@Valid @RequestBody GoodsSearchRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }
        if (request.getIsOnSale() == null) {
            result.error(ResultEnum.G0002);
            return result;
        }

        List<GoodsEx> goodsExs = goodsSearchService.goodsList(request);
        result.success(goodsExs);
        return result;
    }

    /**
     * 商品详情
     *
     * @param goodsId  商品ID
     */
    @ShopLogin
    @GetMapping(value = "/goodsDetail")
    public Result goodsDetail(Long goodsId) {
        Result result = new Result();
        if (goodsId == null) {
            result.error(Message.GOODS_ID_NULL);
            return result;
        }

        GoodsEx goodsEx = goodsSearchService.goodsDetail(goodsId);
        result.success(goodsEx);
        return result;
    }

    /**
     * 商品规格列表
     *
     * @param goodsId  商品ID
     */
    @ShopLogin
    @GetMapping(value = "/goodsSpecList")
    public Result goodsSpecList(Long goodsId) {
        Result result = new Result();
        if (goodsId == null) {
            result.error(Message.GOODS_ID_NULL);
            return result;
        }

        List<GoodsSpec> goodsSpecs = goodsSearchService.goodsSpecList(goodsId);
        result.success(goodsSpecs);
        return result;
    }
}
