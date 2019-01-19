package gcyl.entity.goods.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;

import javax.validation.constraints.NotNull;

/**
 * 商品状态修改
 * 加入店长推荐、默认商品、商品在售
 *
 * @author lican
 * @date 2018/12/19
 */
public class GoodsStateUpRequest extends AbstractRequest {
    /**
     * 店铺ID
     */
    @NotNull(message = Message.SHOP_ID_NULL)
    private Long shopId;

    /**
     * 商品ID
     */
    @NotNull(message = Message.GOODS_ID_NULL)
    private Long goodsId;

    /**
     * 店长推荐
     */
    @NotNull(message = "店长推荐信息异常")
    private Boolean isRecommend;

    /**
     * 默认商品
     */
    @NotNull(message = "默认商品信息异常")
    private Boolean isDefault;

    /**
     * 商品在售
     */
    @NotNull(message = "商品在售信息异常")
    private Boolean isOnSale;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getOnSale() {
        return isOnSale;
    }

    public void setOnSale(Boolean onSale) {
        isOnSale = onSale;
    }
}
