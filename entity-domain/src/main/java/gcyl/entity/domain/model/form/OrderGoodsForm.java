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
     * 商品ID
     */
    private Long goodsId;

    /**
     * 规格ID
     */
    private Long specId;

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
    private BigDecimal specPrice;

    /**
     * 单位
     */
    private String goodsUnit;

    /**
     * 图片
     */
    private String goodsImg;

    /**
     * 数量
     */
    private Integer specNum;

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

    public BigDecimal getSpecPrice() {
        return specPrice;
    }

    public void setSpecPrice(BigDecimal specPrice) {
        this.specPrice = specPrice;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getSpecNum() {
        return specNum;
    }

    public void setSpecNum(Integer specNum) {
        this.specNum = specNum;
    }
}
