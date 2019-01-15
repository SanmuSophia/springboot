package gcyl.entity.goods.service.impl;

import gcyl.entity.common.Constant;
import gcyl.entity.common.enums.CutOffEnum;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.goods.OnSaleEnum;
import gcyl.entity.common.enums.goods.StockEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.common.utils.SnGenerate;
import gcyl.entity.domain.mapper.GoodsMapper;
import gcyl.entity.domain.mapper.GoodsSpecMapper;
import gcyl.entity.domain.mapper.ex.GoodsExtMapper;
import gcyl.entity.domain.mapper.ex.GoodsSpecExtMapper;
import gcyl.entity.domain.model.Goods;
import gcyl.entity.domain.model.GoodsExample;
import gcyl.entity.domain.model.GoodsSpec;
import gcyl.entity.goods.form.SpecAddForm;
import gcyl.entity.goods.form.SpecUpForm;
import gcyl.entity.goods.redis.IGoodsRedisDao;
import gcyl.entity.goods.redis.RedisKeyHelp;
import gcyl.entity.goods.request.GoodsAddRequest;
import gcyl.entity.goods.request.GoodsStateUpRequest;
import gcyl.entity.goods.request.GoodsUpRequest;
import gcyl.entity.goods.service.IGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * 商品管理
 *
 * @author lican
 * @date 2018/12/12
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    private static Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsExtMapper goodsExtMapper;
    @Autowired
    GoodsSpecMapper goodsSpecMapper;
    @Autowired
    GoodsSpecExtMapper goodsSpecExtMapper;
    @Autowired
    SnGenerate snGenerate;

    @Autowired
    IGoodsRedisDao goodsRedisDao;


    /**
     * 商品添加
     * TODO 默认商品有无分类,库存？
     *
     * @param request 商品参数
     * @return 添加成功与否
     */
    @Override
    @Transactional
    public Result add(GoodsAddRequest request) {
        long shopId = request.getShopId();
        String goodsName = request.getGoodsName();
        long categoryId = request.getCategoryId();
        String unit = request.getUnit();
        boolean isRecommend = request.getIsRecommend();
        boolean isOnSale = request.getIsOnSale();
        boolean isDefault = request.getIsDefault();
        String image = request.getImage();
        List<SpecAddForm> specAddForms = request.getSpecAddForms();
        long now = DateUtils.getDateTime();

        //判断商品是否重复
        Result result = this.hasGoods(shopId, categoryId, goodsName, null);
        if (!result.isSuccess()) return result;


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
        goods.setGmtCreate(now);
        goods.setGmtModify(now);
        int i = goodsExtMapper.insertSelective(goods);
        if (i <= 0) {
            logger.info(ResultEnum.G1001.toString());
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
            spec.setGmtCreate(now);
            spec.setGmtModify(now);
            goodsSpecs.add(spec);
        }
        i = goodsSpecExtMapper.batchInsert(goodsSpecs);
        if (i <= 0) {
            logger.info(ResultEnum.G1002.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.error(ResultEnum.G1002);
            return result;
        }

        result.success();
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
        long shopId = request.getShopId();
        long goodsId = request.getGoodsId();
        boolean isRecommend = request.getRecommend();
        boolean isDefault = request.getDefault();
        boolean isOnSale = request.getOnSale();
        long now = DateUtils.getDateTime();

        //判断是否店铺商品
        Result result = this.isShopGoods(shopId, goodsId);
        if (!result.isSuccess()) return result;

        //商品修改信息
        Goods goods = new Goods();
        goods.setId(goodsId);
        goods.setIsRecommend(isRecommend);
        goods.setIsDefault(isDefault);
        goods.setIsOnSale(isOnSale);
        goods.setGmtModify(now);

        int i = goodsMapper.updateByPrimaryKeySelective(goods);
        if (i <= 0) {
            logger.info(ResultEnum.G2001.toString());
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
        long shopId = request.getShopId();
        long goodsId = request.getGoodsId();
        String goodsName = request.getGoodsName();
        long categoryId = request.getCategoryId();
        String unit = request.getUnit();
        boolean isRecommend = request.getIsRecommend();
        boolean isOnSale = request.getIsOnSale();
        boolean isDefault = request.getIsDefault();
        String image = request.getImage();
        long now = DateUtils.getDateTime();
        List<SpecUpForm> specUpForms = request.getSpecUpForms();

        //判断是否店铺商品
        Result result = this.isShopGoods(shopId, goodsId);
        if (!result.isSuccess()) return result;

        //判断商品是否重复
        result = this.hasGoods(shopId, categoryId, goodsName, goodsId);
        if (!result.isSuccess()) return result;

        //商品基本信息修改
        Goods goods = new Goods();
        goods.setId(goodsId);
        goods.setGoodsName(goodsName);
        goods.setCategoryId(categoryId);
        goods.setGoodsUnit(unit);
        goods.setIsRecommend(isRecommend);
        goods.setIsOnSale(isOnSale);
        goods.setIsDefault(isDefault);
        goods.setGoodsImg(image);
        goods.setGmtModify(now);

        int i = goodsMapper.updateByPrimaryKeySelective(goods);
        if (i <= 0) {
            logger.info(ResultEnum.G2001.toString());
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
                addSpec.setGmtCreate(now);
                addSpec.setGmtModify(now);
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
                upSpec.setGmtModify(now);
                upSpecs.add(upSpec);
                specIds.remove(specId);//减去修改的规格剩下的为删除
            }
        }
        //删除
        for (Long specId: specIds) {
            GoodsSpec delSpec = new GoodsSpec();
            delSpec.setId(specId);
            delSpec.setGmtModify(now);
            delSpec.setCutOff(CutOffEnum.TRUE.getCode());
            upSpecs.add(delSpec);
        }

        //修改数据库
        if (addSpecs.size() > 0) {
            i = goodsSpecExtMapper.batchInsert(addSpecs);
            if (i <= 0) {
                logger.info(ResultEnum.G2002.toString());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                result.error(ResultEnum.G2002);
                return result;
            }
        }
        if (upSpecs.size() > 0) {
            i = goodsSpecExtMapper.batchUpdate(upSpecs);
            if (i <= 0) {
                logger.info(ResultEnum.G2003.toString());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                result.error(ResultEnum.G2003);
                return result;
            }
        }

        result.success();
        return result;
    }


    /**
     * 判断商品是否重复
     *
     * @param shopId      店铺ID
     * @param categoryId  类目ID
     * @param goodsName   商品名
     * @return
     */
    private Result hasGoods(long shopId, long categoryId, String goodsName, Long goodsId) {
        Result result = new Result();
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId)
                .andCategoryIdEqualTo(categoryId)
                .andGoodsNameEqualTo(goodsName)
                .andCutOffEqualTo(CutOffEnum.FALSE.getCode());
        //修改商品排除商品本身
        if (goodsId != null) {
            criteria.andIdNotEqualTo(goodsId);
        }

        int count = goodsMapper.countByExample(example);
        if (count >=1 ) {
            logger.info(ResultEnum.G0011.toString());
            result.error(ResultEnum.G0011);
            return result;
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
        //判断是否店铺商品
        Result result = this.isShopGoods(shopId, goodsIds);
        if (!result.isSuccess()) return result;

        long now = DateUtils.getDateTime();
        Goods goods = new Goods();
        goods.setCutOff(CutOffEnum.TRUE.getCode());
        goods.setGmtModify(now);
        GoodsExample example = new GoodsExample();
        example.createCriteria().andIdIn(goodsIds);

        int i = goodsMapper.updateByExampleSelective(goods, example);
        if (i <= 0) {
            logger.info(ResultEnum.G3001.toString());
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
        //判断是否店铺商品
        Result result = this.isShopGoods(shopId, goodsIds);
        if (!result.isSuccess()) return result;

        long now = DateUtils.getDateTime();
        Goods goods = new Goods();
        goods.setIsOnSale(OnSaleEnum.FALSE.getCode());
        goods.setGmtModify(now);
        GoodsExample example = new GoodsExample();
        example.createCriteria().andIdIn(goodsIds);

        int i = goodsMapper.updateByExampleSelective(goods, example);
        if (i <= 0) {
            logger.info(ResultEnum.G2011.toString());
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
        //判断是否店铺商品
        Result result = this.isShopGoods(shopId, goodsIds);
        if (!result.isSuccess()) return result;


        long now = DateUtils.getDateTime();
        Goods goods = new Goods();
        goods.setIsOnSale(OnSaleEnum.TRUE.getCode());
        goods.setGmtModify(now);
        GoodsExample example = new GoodsExample();
        example.createCriteria().andIdIn(goodsIds);

        int i = goodsMapper.updateByExampleSelective(goods, example);
        if (i <= 0) {
            logger.info(ResultEnum.G2021.toString());
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
    public Result restock(long shopId, long goodsId) {
        //判断是否店铺商品
        Result result = this.isShopGoods(shopId, goodsId);
        if (!result.isSuccess()) return result;

        long now = DateUtils.getDateTime();
        GoodsSpec goodsSpec = new GoodsSpec();
        goodsSpec.setGoodsId(goodsId);
        goodsSpec.setGmtModify(now);
        int i = goodsSpecExtMapper.restockByGoods(goodsSpec);
        if (i <= 0) {
            logger.info(ResultEnum.G2031.toString());
            result.error(ResultEnum.G2031);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 库存修改
     *
     * @param specId    规格ID
     * @param num       数量
     * @param stockEnum ADD增加，REDUCE修改
     * @return 修改返回
     */
    @Override
    @Transactional
    public Result changeStock(long specId, int num, StockEnum stockEnum) {
        Result result = new Result();
        String lockKey = RedisKeyHelp.getStockChangeLockKey(specId);
        boolean lock = goodsRedisDao.lock(lockKey, 5);
        if (lock) {
            try {
                Integer stock = goodsSpecExtMapper.selectSpecStock(specId);
                if (stock == null) {
                    result.error(ResultEnum.G2043);
                    return result;
                }

                long now = DateUtils.getDateTime();
                GoodsSpec goodsSpec;
                switch (stockEnum) {
                    case REDUCE:
                        if (stock < num) {
                            result.error(ResultEnum.G2042);
                            return result;
                        }
                        goodsSpec = new GoodsSpec();
                        goodsSpec.setId(specId);
                        goodsSpec.setSpecDayStock(stock - num);
                        goodsSpec.setGmtModify(now);
                        int i = goodsSpecMapper.updateByPrimaryKeySelective(goodsSpec);
                        if (i <= 0) {
                            result.error(ResultEnum.G2041);
                            return result;
                        }
                        break;

                    case ADD:
                        goodsSpec = new GoodsSpec();
                        goodsSpec.setId(specId);
                        goodsSpec.setSpecDayStock(stock + num);
                        goodsSpec.setGmtModify(now);
                        int j = goodsSpecMapper.updateByPrimaryKeySelective(goodsSpec);
                        if (j <= 0) {
                            result.error(ResultEnum.G2041);
                            return result;
                        }
                        break;
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                result.error(ResultEnum.ERROR);
                return result;
            } finally {
                goodsRedisDao.unlock(lockKey);
            }
        } else {
            //若出现并发，可修改为轮询调用
            result.error(ResultEnum.BUSY);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 增加商品销量
     *
     * @param list  商品销量信息
     * @return 增加返回
     */
    @Override
    public Result addSales(List<Map<String, Object>> list) {
        Result result = new Result();
        if (!CollectionUtils.isEmpty(list)) {
            int i = goodsExtMapper.batchAddSales(list);
            if (i <= 0 ){
                result.error(ResultEnum.G2053);
                return result;
            }
        }
        result.success();
        return result;
    }

    /**
     * 判断是否店铺商品
     *
     * @param shopId   店铺ID
     * @param goodsId  商品ID
     */
    private Result isShopGoods(long shopId, long goodsId) {
        Result result = new Result();
        GoodsExample example = new GoodsExample();
        example.createCriteria().andIdEqualTo(goodsId).andShopIdEqualTo(shopId);
        int count = goodsMapper.countByExample(example);
        if (count <=0 ){
            result.error(ResultEnum.G0021);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 判断是否店铺商品
     *
     * @param shopId    店铺ID
     * @param goodsIds  商品ID集合
     */
    private Result isShopGoods(long shopId, List<Long> goodsIds) {
        Result result = new Result();
        GoodsExample example = new GoodsExample();
        example.createCriteria().andIdIn(goodsIds).andShopIdEqualTo(shopId);
        int count = goodsMapper.countByExample(example);
        if (count < goodsIds.size() ){
            result.error(ResultEnum.G0021);
            return result;
        }

        result.success();
        return result;
    }

}
