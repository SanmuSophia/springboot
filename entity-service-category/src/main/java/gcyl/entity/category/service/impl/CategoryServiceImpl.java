package gcyl.entity.category.service.impl;

import gcyl.entity.category.request.CategoryAddRequest;
import gcyl.entity.category.request.CategoryDelRequest;
import gcyl.entity.category.request.CategoryUpRequest;
import gcyl.entity.category.service.ICategoryService;
import gcyl.entity.common.enums.CutOffEnum;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.domain.mapper.CategoryMapper;
import gcyl.entity.domain.mapper.ex.CategoryExtMapper;
import gcyl.entity.domain.model.Category;
import gcyl.entity.domain.model.CategoryExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类目管理
 *
 * @author lican
 * @date 2018/12/12
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    private static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryExtMapper categoryExtMapper;

    /**
     * 类目新增
     *
     * @param request 类目信息
     * @return        添加成与否
     */
    @Override
    public Result add(CategoryAddRequest request) {
        Result result = new Result();
        long shopId = request.getShopId();
        String categoryName = request.getCategoryName();

        //新增参数
        Category category = new Category();
        category.setShopId(shopId);
        category.setCategoryName(categoryName);
        category.setGmtCreate(DateUtils.getDate());
        int i = categoryMapper.insertSelective(category);

        if (i <= 0) {
            logger.info(ResultEnum.C1001.toString());
            result.error(ResultEnum.C1001);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 类目修改
     *
     * @param request 类目信息
     * @return        修改成功与否
     */
    @Override
    public Result update(CategoryUpRequest request) {
        Result result = new Result();
        long categoryId = request.getCategoryId();
        long shopId = request.getShopId();
        String categoryName = request.getCategoryName();

        //修改参数
        Category category = new Category();
        category.setCategoryName(categoryName);

        //修改条件
        CategoryExample example = new CategoryExample();
        example.createCriteria()
                .andIdEqualTo(categoryId)
                .andShopIdEqualTo(shopId);
        int i = categoryMapper.updateByExampleSelective(category, example);

        if (i <= 0) {
            logger.info(ResultEnum.C2001.toString());
            result.error(ResultEnum.C2001);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 类目删除
     *
     * @param request 类目信息
     * @return        删除成功与否
     */
    @Override
    public Result delete(CategoryDelRequest request) {
        Result result = new Result();
        long categoryId = request.getCategoryId();
        long shopId = request.getShopId();

        //删除信息
        Category category = new Category();
        category.setCutOff(CutOffEnum.TRUE.getCode());

        //删除条件
        CategoryExample example = new CategoryExample();
        example.createCriteria()
                .andIdEqualTo(categoryId)
                .andShopIdEqualTo(shopId);
        int i = categoryMapper.updateByExampleSelective(category, example);

        if (i <= 0) {
            logger.info(ResultEnum.C3001.toString());
            result.error(ResultEnum.C3001);
            return result;
        }

        result.success();
        return result;
    }
}
