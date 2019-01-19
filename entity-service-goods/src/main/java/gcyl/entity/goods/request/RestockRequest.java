package gcyl.entity.goods.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;

import javax.validation.constraints.NotNull;

/**
 * 恢复库存参数
 *
 * @author lican
 * @date 2019/1/3
 */
public class RestockRequest extends AbstractRequest {

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
