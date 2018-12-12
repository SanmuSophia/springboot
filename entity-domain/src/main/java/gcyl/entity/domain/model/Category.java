package gcyl.entity.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private Long id;

    private Long shopId;

    private String categoryName;

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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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