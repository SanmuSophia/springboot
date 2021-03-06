package gcyl.entity.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.order_id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private Long orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.goods_id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private Long goodsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.goods_name
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private String goodsName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.goods_unit
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private String goodsUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.goods_img
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private String goodsImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.spec_id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private Long specId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.spec_name
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private String specName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.spec_price
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private BigDecimal specPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_order_detail.spec_num
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private Integer specNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tyg_ms_order_detail
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.id
     *
     * @return the value of tyg_ms_order_detail.id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.id
     *
     * @param id the value for tyg_ms_order_detail.id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.order_id
     *
     * @return the value of tyg_ms_order_detail.order_id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.order_id
     *
     * @param orderId the value for tyg_ms_order_detail.order_id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.goods_id
     *
     * @return the value of tyg_ms_order_detail.goods_id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.goods_id
     *
     * @param goodsId the value for tyg_ms_order_detail.goods_id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.goods_name
     *
     * @return the value of tyg_ms_order_detail.goods_name
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.goods_name
     *
     * @param goodsName the value for tyg_ms_order_detail.goods_name
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.goods_unit
     *
     * @return the value of tyg_ms_order_detail.goods_unit
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public String getGoodsUnit() {
        return goodsUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.goods_unit
     *
     * @param goodsUnit the value for tyg_ms_order_detail.goods_unit
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.goods_img
     *
     * @return the value of tyg_ms_order_detail.goods_img
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.goods_img
     *
     * @param goodsImg the value for tyg_ms_order_detail.goods_img
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.spec_id
     *
     * @return the value of tyg_ms_order_detail.spec_id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public Long getSpecId() {
        return specId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.spec_id
     *
     * @param specId the value for tyg_ms_order_detail.spec_id
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.spec_name
     *
     * @return the value of tyg_ms_order_detail.spec_name
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.spec_name
     *
     * @param specName the value for tyg_ms_order_detail.spec_name
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setSpecName(String specName) {
        this.specName = specName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.spec_price
     *
     * @return the value of tyg_ms_order_detail.spec_price
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public BigDecimal getSpecPrice() {
        return specPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.spec_price
     *
     * @param specPrice the value for tyg_ms_order_detail.spec_price
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setSpecPrice(BigDecimal specPrice) {
        this.specPrice = specPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_order_detail.spec_num
     *
     * @return the value of tyg_ms_order_detail.spec_num
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public Integer getSpecNum() {
        return specNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_order_detail.spec_num
     *
     * @param specNum the value for tyg_ms_order_detail.spec_num
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    public void setSpecNum(Integer specNum) {
        this.specNum = specNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyg_ms_order_detail
     *
     * @mbggenerated Wed Jan 16 17:28:16 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsUnit=").append(goodsUnit);
        sb.append(", goodsImg=").append(goodsImg);
        sb.append(", specId=").append(specId);
        sb.append(", specName=").append(specName);
        sb.append(", specPrice=").append(specPrice);
        sb.append(", specNum=").append(specNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}