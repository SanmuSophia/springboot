package gcyl.entity.goods.service.impl;

import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.mapper.ext.CartMapper;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.redis.ICartRedisDao;
import gcyl.entity.goods.request.CartRequest;
import gcyl.entity.goods.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车管理
 *
 * @author lican
 * @date 2018/12/24
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    ICartRedisDao cartRedisDao;
    @Autowired
    CartMapper cartMapper;

    /**
     * 获取用户购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @return  购物车商品列表
     */
    @Override
    public List<CartForm> getUser(long shopId, long tableNum, long userId) {
        return cartRedisDao.getUser(shopId, tableNum, userId);
    }

    /**
     * 获取餐桌购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return  购物车商品列表
     */
    @Override
    public List<CartForm> getTable(long shopId, long tableNum) {
        List<CartForm> cartForms = cartRedisDao.getTable(shopId, tableNum);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("shopId", shopId);
        paramMap.put("isDefault", true);
        List<CartForm> defaultGoods = cartMapper.selectByMap(paramMap);
        cartForms.addAll(defaultGoods);
        return cartForms;
    }

    /**
     * 添加商品
     *
     * @param request  商品参数
     * @return  添加结果
     */
    @Override
    public Result add(CartRequest request) {
        Result result = new Result();
        long userId = request.getUserId();
        long shopId = request.getShopId();
        long tableNum = request.getTableNum();
        long specId = request.getSpecId();
        int num = request.getNum();

        //添加个人购物车
        CartForm cartForm = cartMapper.selectBySpecId(specId);
        if (cartForm == null) {
            result.error(ResultEnum.CT1001);
            return result;
        }
        if (cartForm.getSpecStock() < num) {
            result.error(ResultEnum.CT1002);
            return result;
        }
        cartForm.setSpecStock(null);
        cartRedisDao.addUser(shopId, tableNum, userId, num, cartForm);

        //添加餐桌购物车
        Map<String, Object> userMap = cartMapper.selectUserInfo(userId);
        if (!CollectionUtils.isEmpty(userMap)) {
            String userName = (String)userMap.get("name");
            String userLogo = (String)userMap.get("logo");
            cartForm.setUserName(userName);
            cartForm.setUserLogo(userLogo);
        }
        cartRedisDao.addTable(shopId, tableNum, num, cartForm);

        result.success();
        return result;
    }

    /**
     * 移除个人商品
     *
     * @param request  商品参数
     * @return  添加结果
     */
    @Override
    public Result removeUser(CartRequest request) {
        Result result = new Result();
        long userId = request.getUserId();
        long shopId = request.getShopId();
        long tableNum = request.getTableNum();
        long specId = request.getSpecId();
        int num = request.getNum();

        cartRedisDao.removeUser(shopId, tableNum, userId, specId,  num);
        result.success();
        return result;
    }

    /**
     * 清个人户购物车
     *
     * @param request  商品参数
     * @return  添加结果
     */
    @Override
    public Result clearUser(CartRequest request) {
        Result result = new Result();
        long userId = request.getUserId();
        long shopId = request.getShopId();
        long tableNum = request.getTableNum();

        cartRedisDao.clearUser(shopId, tableNum, userId);
        result.success();
        return result;
    }
}
