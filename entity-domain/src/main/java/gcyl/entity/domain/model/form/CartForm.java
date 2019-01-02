package gcyl.entity.domain.model.form;

import java.math.BigDecimal;

/**
 * 购物车参数
 *
 * @author lican
 * @date 2018/12/24
 */
public class CartForm {
    /***** 公共购物车参数 *****/
    /**
     * 类目
     */
    private String categoryName;

    /**
     * 用户头像
     */
    private String userLogo;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 是否默认
     */
    private Boolean isDefault;


    /***** 个人购物车参数 *****/

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品规格ID
     */
    private Long specId;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 图片
     */
    private String goodsImage;

    /**
     * 规格名
     */
    private String specName;

    /**
     * 规格价格
     */
    private BigDecimal specPrice;

    /**
     * 规格库存
     */
    private Integer specStock;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 单位
     */
    private String goodsUnit;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
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

    public Integer getSpecStock() {
        return specStock;
    }

    public void setSpecStock(Integer specStock) {
        this.specStock = specStock;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }
}
