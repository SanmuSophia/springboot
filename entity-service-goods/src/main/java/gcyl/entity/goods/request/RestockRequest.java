package gcyl.entity.goods.request;

import javax.validation.constraints.NotNull;

/**
 * 恢复库存参数
 *
 * @author lican
 * @date 2019/1/3
 */
public class RestockRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = "店铺信息有误")
    private Long shopId;

    /**
     * 商品ID
     */
    @NotNull(message = "商品信息有误")
    private Long goodsId;

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
}
