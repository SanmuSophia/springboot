package gcyl.entity.goods.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 批量操作参数
 *
 * @author lican
 * @date 2019/1/3
 */
public class BatchUpRequest extends AbstractRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = Message.SHOP_ID_NULL)
    private Long shopId;

    /**
     * 商品ID集合
     */
    @NotNull(message = Message.GOODS_ID_NULL)
    @Size(min = 1, message = "商品信息有误")
    private List<Long> goodsIds;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public List<Long> getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(List<Long> goodsIds) {
        this.goodsIds = goodsIds;
    }
}
