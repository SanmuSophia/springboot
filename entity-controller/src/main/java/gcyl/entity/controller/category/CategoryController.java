package gcyl.entity.controller.category;

import gcyl.entity.category.request.CategoryAddRequest;
import gcyl.entity.category.request.CategoryDelRequest;
import gcyl.entity.category.request.CategoryUpRequest;
import gcyl.entity.category.service.ICategoryService;
import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 类目管理
 *
 * @author lican
 * @date 2019/1/2
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    /**
     * 新增
     *
     * @param request        新增参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @PostMapping(value = "/add")
    public Result add(@Valid @RequestBody CategoryAddRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return categoryService.add(request);
    }

    /**
     * 修改
     *
     * @param request        修改参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @PostMapping(value = "/update")
    public Result update(@Valid @RequestBody CategoryUpRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return categoryService.update(request);
    }

    /**
     * 删除
     *
     * @param request        修改参数
     * @param bindingResult  参数验证
     */
    @ShopLogin
    @PostMapping(value = "/delete")
    public Result delete(@Valid @RequestBody CategoryDelRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }

        return categoryService.delete(request);
    }
}
