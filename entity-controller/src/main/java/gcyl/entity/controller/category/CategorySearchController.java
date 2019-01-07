package gcyl.entity.controller.category;

import gcyl.entity.category.service.ICategorySearchService;
import gcyl.entity.category.vo.ShopCategoryVO;
import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 类目搜索
 *
 * @author lican
 * @date 2019/1/2
 */
@Controller
@RequestMapping("/category")
public class CategorySearchController {

    @Autowired
    ICategorySearchService categorySearchService;

    /**
     * 店铺类目
     *
     * @param shopId  店铺ID
     */
    @ShopLogin
    @RequestMapping("/getShopCategory")
    @ResponseBody
    public Result getShopCategory(Long shopId) {
        Result result = new Result();
        if (shopId == null) {
            result.setMsg("店铺信息有误");
            return result;
        }
        List<Category> categories = categorySearchService.getShopCategory(shopId);
        boolean hasDefault = categorySearchService.hasDefault(shopId);

        ShopCategoryVO shopCategoryVO = new ShopCategoryVO();
        shopCategoryVO.setCategories(categories);
        shopCategoryVO.setHasDefault(hasDefault);
        result.success(shopCategoryVO);
        return result;
    }

}
