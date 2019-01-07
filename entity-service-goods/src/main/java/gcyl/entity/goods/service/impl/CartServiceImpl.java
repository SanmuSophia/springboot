package gcyl.entity.goods.service.impl;

import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.mapper.ex.CartMapper;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.redis.ICartRedisDao;
import gcyl.entity.goods.request.CartAddRequest;
import gcyl.entity.goods.request.CartDelRequest;
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
     * 获取餐桌购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return  购物车商品列表
     */
    @Override
    public List<CartForm> get(long shopId, long tableNum) {
        List<CartForm> cartForms = cartRedisDao.getTable(shopId, tableNum);

        //获取默认商品
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
    public Result add(CartAddRequest request) {
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
//        cartRedisDao.addUser(shopId, tableNum, userId, num, cartForm);

        //添加餐桌购物车
        Map<String, Object> userMap = cartMapper.selectUserInfo(userId);
        if (!CollectionUtils.isEmpty(userMap)) {
            String userName = (String)userMap.get("name");
            String userLogo = (String)userMap.get("logo");
            cartForm.setUserName(userName);
            cartForm.setUserLogo(userLogo);
        }
        long i = cartRedisDao.addTable(shopId, tableNum, num, cartForm);
        if (i <= 0) {
            result.error(ResultEnum.CT1003);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 移除商品
     *
     * @param request  商品参数
     * @return  添加结果
     */
    @Override
    public Result remove(CartDelRequest request) {
        Result result = new Result();
        long shopId = request.getShopId();
        long tableNum = request.getTableNum();
        long specId = request.getSpecId();
        int num = request.getNum();

        long i = cartRedisDao.removeTable(shopId, tableNum, specId, num);
        if (i <= 0) {
            result.error(ResultEnum.CT3002);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 清空购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return  清空结果
     */
    @Override
    public Result clear(long shopId, long tableNum) {
        Result result = new Result();
        long i = cartRedisDao.clear(shopId, tableNum);
        if (i <= 0) {
            result.error(ResultEnum.CT3003);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 获取用户购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @return  购物车商品列表
     */
//    @Override
//    public List<CartForm> getUser(long shopId, long tableNum, long userId) {
//        return cartRedisDao.getUser(shopId, tableNum, userId);
//    }
}
