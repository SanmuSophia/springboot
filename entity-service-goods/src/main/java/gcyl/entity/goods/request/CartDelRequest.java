package gcyl.entity.goods.request;

import gcyl.entity.common.base.AbstractRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 购物车删除参数
 *
 * @author lican
 * @date 2018/12/24
 */
public class CartDelRequest extends AbstractRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = "店铺信息有误")
    private Long shopId;

    /**
     * 桌号
     */
    @NotNull(message = "餐桌号有误")
    private Long tableNum;

    /**
     * 商品ID
     */
    @NotNull(message = "商品信息有误")
    private Long goodsId;

    /**
     * 商品规格ID
     */
    @NotNull(message = "商品规格有误")
    private Long specId;

    /**
     * 商品数量
     */
    @NotNull(message = "商品数量有误")
    @Min(value = 1, message = "商品数量有误")
    private Integer num;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getTableNum() {
        return tableNum;
    }

    public void setTableNum(Long tableNum) {
        this.tableNum = tableNum;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
