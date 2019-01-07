package gcyl.entity.goods.service.impl;

import com.github.pagehelper.PageHelper;
import gcyl.entity.common.enums.CutOffEnum;
import gcyl.entity.goods.Enum.SortEnum;
import gcyl.entity.domain.mapper.ex.GoodsExtMapper;
import gcyl.entity.domain.mapper.ex.GoodsSpecExtMapper;
import gcyl.entity.domain.model.GoodsSpec;
import gcyl.entity.domain.model.GoodsSpecExample;
import gcyl.entity.domain.model.ex.GoodsEx;
import gcyl.entity.goods.request.GoodsSearchRequest;
import gcyl.entity.goods.service.IGoodsSearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品搜索
 *
 * @author lican
 * @date 2018/12/18
 */
@Service
public class GoodsSearchServiceImpl implements IGoodsSearchService {

    @Autowired
    GoodsExtMapper goodsExtMapper;
    @Autowired
    GoodsSpecExtMapper goodsSpecExtMapper;

    /**
     * 商品搜索
     * @param request 搜索参数
     * @return 列表商品
     */
    @Override
    public List<GoodsEx> goodsList(GoodsSearchRequest request) {
        long shopId = request.getShopId();
        Boolean isOnSale = request.getIsOnSale();
        SortEnum sortEnum = request.getSortEnum();

        //热销商品单独处理
        Boolean hot = request.getHot();
        if (hot != null && hot) {
            return this.selectHotGoods(shopId, isOnSale, sortEnum);
        }

        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        Boolean sellOut = request.getSellOut();
        Boolean isRecommend = request.getIsRecommend();
        Boolean isDefault = request.getIsDefault();
        String categoryId = request.getCategoryId();
        String likeValue = request.getLikeValue();

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("shopId", shopId);
        paramMap.put("sellOut", sellOut);
        paramMap.put("isRecommend", isRecommend);
        paramMap.put("isDefault", isDefault);
        paramMap.put("isOnSale", isOnSale);
        paramMap.put("categoryId", categoryId);
        if (StringUtils.isNotBlank(likeValue))
            paramMap.put("likeValue", "%" + likeValue + "%");
        //排序
        switch (sortEnum) {
            case SELL_OUT:
                paramMap.put("orderBy", "minSpecStock,stock");
                break;
        }

        PageHelper.startPage(pageNum, pageSize);
        return goodsExtMapper.selectByMap(paramMap);
    }

    /**
     * 获取热销商品(10件)
     * 1.查询热销的十件商品
     * 2.根据排序规则排序(目前逻辑为将售罄商品放在最前面)
     * 3.过滤满足条件的商品
     * @param shopId    店铺ID
     * @param isOnSale  是否在售
     * @param sortEnum  排序
     * @return 热销商品列表
     */
    private List<GoodsEx> selectHotGoods(long shopId, Boolean isOnSale, SortEnum sortEnum) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("shopId", shopId);
        paramMap.put("orderBy", "month_sales");

        PageHelper.startPage(1, 10);
        List<GoodsEx> list = goodsExtMapper.selectByMap(paramMap);

        switch (sortEnum) {
            case SELL_OUT:
                list = list.stream().sorted(Comparator.comparing(GoodsEx::getMinSpecStock)
                        .thenComparing(GoodsEx::getStock)).collect(Collectors.toList());
                break;
        }

        if (isOnSale != null) {
            list = list.stream().filter(goodsExt -> goodsExt.getIsOnSale() == isOnSale)
                    .collect(Collectors.toList());
        }

        return list;
    }

    /**
     * 商品详情
     * @param id 商品主键
     * @return 商品详情
     */
    @Override
    public GoodsEx goodsDetail(long id) {
        return goodsExtMapper.selectGoodsDetail(id);
    }

    /**
     * 获取商品所有规格
     *
     * @param goodsId 商品ID
     * @return 规格列表
     */
    @Override
    public List<GoodsSpec> goodsSpecList(long goodsId) {
        GoodsSpecExample example = new GoodsSpecExample();
        example.createCriteria()
                .andGoodsIdEqualTo(goodsId)
                .andCutOffEqualTo(CutOffEnum.FALSE.getCode());
        return goodsSpecExtMapper.selectByExample(example);
    }

}
