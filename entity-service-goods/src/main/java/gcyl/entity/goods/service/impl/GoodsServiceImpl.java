package gcyl.entity.goods.service.impl;

import gcyl.entity.common.Constant;
import gcyl.entity.common.enums.CutOffEnum;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.goods.OnSaleEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.common.utils.SnGenerate;
import gcyl.entity.domain.mapper.GoodsMapper;
import gcyl.entity.domain.mapper.ext.GoodsExtMapper;
import gcyl.entity.domain.mapper.ext.GoodsSpecExtMapper;
import gcyl.entity.domain.model.Goods;
import gcyl.entity.domain.model.GoodsExample;
import gcyl.entity.domain.model.GoodsSpec;
import gcyl.entity.goods.form.SpecAddForm;
import gcyl.entity.goods.form.SpecUpForm;
import gcyl.entity.goods.redis.IGoodsRedisDao;
import gcyl.entity.goods.request.GoodsAddRequest;
import gcyl.entity.goods.request.GoodsStateUpRequest;
import gcyl.entity.goods.request.GoodsUpRequest;
import gcyl.entity.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.*;

/**
 * 商品管理
 * 1.店铺修改商品操作where条件带上shopId,
 * 防止在店铺和商品信息不一致的情况的被修改
 *
 * @author lican
 * @date 2018/12/12
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsExtMapper goodsExtMapper;
    @Autowired
    GoodsSpecExtMapper goodsSpecExtMapper;
    @Autowired
    SnGenerate snGenerate;

    /**
     * 商品添加
     *
     * @param request 商品参数
     * @return 添加成功与否
     */
    @Override
    @Transactional
    public Result add(GoodsAddRequest request) {
        Result result = new Result();
        long shopId = request.getShopId();
        String goodsName = request.getGoodsName();
        long categoryId = request.getCategoryId();
        String unit = request.getUnit();
        boolean isRecommend = request.getIsRecommend();
        boolean isOnSale = request.getIsOnSale();
        boolean isDefault = request.getIsDefault();
        String image = request.getImage();
        Date date = DateUtils.getDate();
        List<SpecAddForm> specAddForms = request.getSpecAddForms();

        //生成商品编号
        String goodsSn = snGenerate.snGenerate(Constant.G_SN_PREFIX);

        //商品基本信息插入
        Goods goods = new Goods();
        goods.setShopId(shopId);
        goods.setGoodsSn(goodsSn);
        goods.setGoodsName(goodsName);
        goods.setCategoryId(categoryId);
        goods.setGoodsUnit(unit);
        goods.setIsRecommend(isRecommend);
        goods.setIsOnSale(isOnSale);
        goods.setIsDefault(isDefault);
        goods.setGoodsImg(image);
        goods.setGmtCreate(DateUtils.getDate());
        int i = goodsExtMapper.insertSelective(goods);
        if (i <= 0) {
            result.error(ResultEnum.G1001);
            return result;
        }

        //商品规格批量插入
        List<GoodsSpec> goodsSpecs = new ArrayList<>();
        Long goodsId = goods.getId();
        for (SpecAddForm form : specAddForms) {
            String specKey = form.getSpecKey();
            String specName = form.getSpecName();
            BigDecimal specPrice = form.getSpecPrice();
            int specDayStock = form.getSpecDayStock();

            //规格信息保存
            GoodsSpec spec = new GoodsSpec();
            spec.setGoodsId(goodsId);
            spec.setSpecKey(specKey);
            spec.setSpecName(specName);
            spec.setSpecPrice(specPrice);
            spec.setSpecDayStock(specDayStock);
            spec.setSpecStock(specDayStock);
            spec.setGmtCreate(date);
            goodsSpecs.add(spec);
        }
        i = goodsSpecExtMapper.batchInsert(goodsSpecs);
        if (i <= 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.error(ResultEnum.G1002);
            return result;
        }
        return result;
    }

    /**
     * 商品状态修改
     * 加入店长推荐、默认商品、商品在售
     *
     * @param request 修改参数
     * @return 修改结果
     */
    @Override
    public Result upState(GoodsStateUpRequest request) {
        Result result = new Result();
        long shopId = request.getShopId();
        long goodsId = request.getGoodsId();
        boolean isRecommend = request.getRecommend();
        boolean isDefault = request.getDefault();
        boolean isOnSale = request.getOnSale();

        //商品修改信息
        Goods goods = new Goods();
        goods.setIsRecommend(isRecommend);
        goods.setIsDefault(isDefault);
        goods.setIsOnSale(isOnSale);

        //修改条件
        GoodsExample example = new GoodsExample();
        example.createCriteria().andShopIdEqualTo(shopId).andIdEqualTo(goodsId);

        int i = goodsMapper.updateByExampleSelective(goods, example);
        if (i <= 0) {
            result.error(ResultEnum.G2001);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 商品修改
     * @param request 修改参数
     * @return 修改结果
     */
    @Override
    @Transactional
    public Result update(GoodsUpRequest request) {
        Result result = new Result();
        long shopId = request.getShopId();
        long goodsId = request.getGoodsId();
        String goodsName = request.getGoodsName();
        long categoryId = request.getCategoryId();
        String unit = request.getUnit();
        boolean isRecommend = request.getIsRecommend();
        boolean isOnSale = request.getIsOnSale();
        boolean isDefault = request.getIsDefault();
        String image = request.getImage();
        Date date = DateUtils.getDate();
        List<SpecUpForm> specUpForms = request.getSpecUpForms();

        //商品基本信息修改
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setCategoryId(categoryId);
        goods.setGoodsUnit(unit);
        goods.setIsRecommend(isRecommend);
        goods.setIsOnSale(isOnSale);
        goods.setIsDefault(isDefault);
        goods.setGoodsImg(image);

        //修改条件
        GoodsExample example = new GoodsExample();
        example.createCriteria().andShopIdEqualTo(shopId).andIdEqualTo(goodsId);

        int i = goodsMapper.updateByPrimaryKeySelective(goods);
        if (i <= 0) {
            result.error(ResultEnum.G2001);
            return result;
        }

        //商品规格批量修改（新增，修改，删除）
        List<GoodsSpec> addSpecs = new ArrayList<>();
        List<GoodsSpec> upSpecs = new ArrayList<>();
        List<Long> specIds = goodsSpecExtMapper.selectSpecIds(goodsId);//原有的规格ID
        for (SpecUpForm form : specUpForms) {
            Long specId = form.getSpecId();
            String specKey = form.getSpecKey();
            String specName = form.getSpecName();
            BigDecimal specPrice = form.getSpecPrice();
            int specDayStock = form.getSpecDayStock();

            //新增
            if (specId == null) {
                GoodsSpec addSpec = new GoodsSpec();
                addSpec.setGoodsId(goodsId);
                addSpec.setSpecKey(specKey);
                addSpec.setSpecName(specName);
                addSpec.setSpecPrice(specPrice);
                addSpec.setSpecDayStock(specDayStock);
                addSpec.setSpecStock(specDayStock);
                addSpec.setGmtCreate(date);
                addSpecs.add(addSpec);
            } else {
                //修改
                GoodsSpec upSpec = new GoodsSpec();
                upSpec.setId(specId);
                upSpec.setSpecKey(specKey);
                upSpec.setSpecName(specName);
                upSpec.setSpecPrice(specPrice);
                upSpec.setSpecDayStock(specDayStock);
                upSpec.setSpecStock(specDayStock);
                upSpecs.add(upSpec);
                specIds.remove(specId);//减去修改的规格剩下的为删除
            }
        }
        //删除
        for (Long specId: specIds) {
            GoodsSpec delSpec = new GoodsSpec();
            delSpec.setId(specId);
            delSpec.setCutOff(CutOffEnum.TRUE.getCode());
            upSpecs.add(delSpec);
        }

        //修改数据库
        if (addSpecs.size() > 0) {
            i = goodsSpecExtMapper.batchInsert(addSpecs);
            if (i <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                result.error(ResultEnum.G2002);
                return result;
            }
        }
        if (upSpecs.size() > 0) {
            i = goodsSpecExtMapper.batchUpdate(upSpecs);
            if (i <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                result.error(ResultEnum.G2003);
                return result;
            }
        }

        result.success();
        return result;
    }

    /**
     * 商品删除
     * @param shopId    店铺ID
     * @param goodsIds  商品ID集合
     * @return 删除结果
     */
    @Override
    public Result delete(long shopId, List<Long> goodsIds) {
        Result result = new Result();
        Goods goods = new Goods();
        goods.setCutOff(CutOffEnum.TRUE.getCode());
        GoodsExample example = new GoodsExample();
        example.createCriteria().andShopIdEqualTo(shopId).andIdIn(goodsIds);

        int i = goodsMapper.updateByExampleSelective(goods, example);
        if (i <= 0) {
            result.error(ResultEnum.G3001);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 商品下架
     * @param shopId    店铺ID
     * @param goodsIds  商品ID集合
     * @return 下架结果
     */
    @Override
    public Result offShelve(long shopId, List<Long> goodsIds) {
        Result result = new Result();
        Goods goods = new Goods();
        goods.setIsOnSale(OnSaleEnum.FALSE.getCode());
        GoodsExample example = new GoodsExample();
        example.createCriteria().andShopIdEqualTo(shopId).andIdIn(goodsIds);

        int i = goodsMapper.updateByExampleSelective(goods, example);
        if (i <= 0) {
            result.error(ResultEnum.G2011);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 商品上架
     * @param shopId    店铺ID
     * @param goodsIds  商品ID集合
     * @return 上架结果
     */
    @Override
    public Result onShelve(long shopId, List<Long> goodsIds) {
        Result result = new Result();
        Goods goods = new Goods();
        goods.setIsOnSale(OnSaleEnum.TRUE.getCode());
        GoodsExample example = new GoodsExample();
        example.createCriteria().andShopIdEqualTo(shopId).andIdIn(goodsIds);

        int i = goodsMapper.updateByExampleSelective(goods, example);
        if (i <= 0) {
            result.error(ResultEnum.G2021);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 恢复库存
     *
     * @param shopId   店铺ID
     * @param goodsId  商品ID
     * @return
     */
    @Override
    @Transactional
    public Result restock(long shopId, long goodsId) {
        Result result = new Result();
        Goods goods = new Goods();
        goods.setGmtModify(DateUtils.getDate());
        GoodsExample example = new GoodsExample();
        example.createCriteria().andShopIdEqualTo(shopId).andIdEqualTo(goodsId);

        int i = goodsMapper.updateByExampleSelective(goods, example);
        if (i <= 0) {
            result.error(ResultEnum.G2031);
            return result;
        }

        i = goodsSpecExtMapper.restockByGoodsId(goodsId);
        if (i <= 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.error(ResultEnum.G2032);
            return result;
        }

        result.success();
        return result;
    }
}
