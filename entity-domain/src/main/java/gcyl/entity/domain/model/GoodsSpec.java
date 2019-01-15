package gcyl.entity.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsSpec implements Serializable {
    private Long id;

    private Long goodsId;

    private String specKey;

    private String specName;

    private BigDecimal specPrice;

    private Integer specDayStock;

    private Integer specStock;

    private Integer specSalesCount;

    private Integer specMonthSales;

    private Long gmtCreate;

    private Long gmtModify;

    private Boolean cutOff;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecKey() {
        return specKey;
    }

    public void setSpecKey(String specKey) {
        this.specKey = specKey;
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

    public Integer getSpecDayStock() {
        return specDayStock;
    }

    public void setSpecDayStock(Integer specDayStock) {
        this.specDayStock = specDayStock;
    }

    public Integer getSpecStock() {
        return specStock;
    }

    public void setSpecStock(Integer specStock) {
        this.specStock = specStock;
    }

    public Integer getSpecSalesCount() {
        return specSalesCount;
    }

    public void setSpecSalesCount(Integer specSalesCount) {
        this.specSalesCount = specSalesCount;
    }

    public Integer getSpecMonthSales() {
        return specMonthSales;
    }

    public void setSpecMonthSales(Integer specMonthSales) {
        this.specMonthSales = specMonthSales;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Long gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Boolean getCutOff() {
        return cutOff;
    }

    public void setCutOff(Boolean cutOff) {
        this.cutOff = cutOff;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", specKey=").append(specKey);
        sb.append(", specName=").append(specName);
        sb.append(", specPrice=").append(specPrice);
        sb.append(", specDayStock=").append(specDayStock);
        sb.append(", specStock=").append(specStock);
        sb.append(", specSalesCount=").append(specSalesCount);
        sb.append(", specMonthSales=").append(specMonthSales);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append(", cutOff=").append(cutOff);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}