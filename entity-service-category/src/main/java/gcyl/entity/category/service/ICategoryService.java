package gcyl.entity.category.service;

import gcyl.entity.category.request.CategoryAddRequest;
import gcyl.entity.category.request.CategoryDelRequest;
import gcyl.entity.category.request.CategoryUpRequest;
import gcyl.entity.common.result.Result;

/**
 * 类目管理
 *
 * @author lican
 * @date 2018/12/12
 */
public interface ICategoryService {

    /**
     * 类目新增
     *
     * @param request 类目信息
     */
    Result add(CategoryAddRequest request);

    /**
     * 类目修改
     *
     * @param request 类目信息
     */
    Result update(CategoryUpRequest request);

    /**
     * 类目删除
     *
     * @param request 类目信息
     */
    Result delete(CategoryDelRequest request);
}
