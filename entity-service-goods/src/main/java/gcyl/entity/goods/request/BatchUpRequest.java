package gcyl.entity.goods.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 批量操作参数
 *
 * @author lican
 * @date 2019/1/3
 */
public class BatchUpRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = "店铺信息有误")
    private Long shopId;

    /**
     * 商品ID集合
     */
    @NotNull(message = "商品信息有误")
    @Min(value = 1, message = "商品信息有误")
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
