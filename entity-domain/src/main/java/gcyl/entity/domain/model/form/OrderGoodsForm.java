package gcyl.entity.domain.model.form;

import java.math.BigDecimal;

/**
 * 订单商品参数
 *
 * @author lican
 * @date 2018/12/28
 */
public class OrderGoodsForm {

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 规格名
     */
    private String specName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 单位
     */
    private String unit;

    /**
     * 图片
     */
    private String image;

    /**
     * 数量
     */
    private Integer num;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
