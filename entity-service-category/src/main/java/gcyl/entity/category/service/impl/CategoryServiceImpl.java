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
        long shopId = request.getShopId();
        String categoryName = request.getCategoryName();
        long now = DateUtils.getDateTime();

        //判断类目是否已存在
        Result result = this.hasCategory(shopId, categoryName, null);
        if (!result.isSuccess()) return result;


        //新增参数
        Category category = new Category();
        category.setShopId(shopId);
        category.setCategoryName(categoryName);
        category.setGmtCreate(now);
        category.setGmtModify(now);
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
        long categoryId = request.getCategoryId();
        long shopId = request.getShopId();
        String categoryName = request.getCategoryName();

        //验证是否店铺类目
        Result result = this.isShopCategory(shopId, categoryId);
        if (!result.isSuccess()) return result;

        //判断新类目是否已存在
        result = this.hasCategory(shopId, categoryName, categoryId);
        if (!result.isSuccess()) return result;

        //修改参数
        Category category = new Category();
        category.setId(categoryId);
        category.setCategoryName(categoryName);
        category.setGmtModify(DateUtils.getDateTime());

        int i = categoryMapper.updateByPrimaryKeySelective(category);

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
        long categoryId = request.getCategoryId();
        long shopId = request.getShopId();

        //验证是否店铺类目
        Result result = this.isShopCategory(shopId, categoryId);
        if (!result.isSuccess()) return result;

        //删除信息
        Category category = new Category();
        category.setId(categoryId);
        category.setCutOff(CutOffEnum.TRUE.getCode());
        category.setGmtModify(DateUtils.getDateTime());

        int i = categoryMapper.updateByPrimaryKeySelective(category);

        if (i <= 0) {
            logger.info(ResultEnum.C3001.toString());
            result.error(ResultEnum.C3001);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 判断是否店铺类目
     *
     * @param shopId      店铺ID
     * @param categoryId  类目ID
     */
    public Result isShopCategory(long shopId, long categoryId) {
        Result result = new Result();
        CategoryExample example = new CategoryExample();
        example.createCriteria().andIdEqualTo(categoryId).andShopIdEqualTo(shopId);
        int count = categoryMapper.countByExample(example);

        if (count <= 0) {
            result.error(ResultEnum.C0001);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 判断类目是否已存在
     *
     * @param shopId        店铺ID
     * @param categoryName  类目名
     * @param categoryId    类目ID
     */
    private Result hasCategory(long shopId, String categoryName, Long categoryId){
        Result result = new Result();
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId)
                .andCategoryNameEqualTo(categoryName)
                .andCutOffEqualTo(CutOffEnum.FALSE.getCode());

        //修改时排除类目本身
        if (categoryId != null) {
            criteria.andIdNotEqualTo(categoryId);
        }

        int count = categoryMapper.countByExample(example);
        if (count >= 1) {
            logger.info(ResultEnum.C0002.toString());
            result.error(ResultEnum.C0002);
            return result;
        }

        result.success();
        return result;
    }
}
