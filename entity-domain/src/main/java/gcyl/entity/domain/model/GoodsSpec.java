package gcyl.entity.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoodsSpec implements Serializable {
    private Long id;

    private String goodsSn;

    private String specName;

    private BigDecimal specPrice;

    private Long specStock;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte cutOff;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
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

    public Long getSpecStock() {
        return specStock;
    }

    public void setSpecStock(Long specStock) {
        this.specStock = specStock;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Byte getCutOff() {
        return cutOff;
    }

    public void setCutOff(Byte cutOff) {
        this.cutOff = cutOff;
    }
}