package gcyl.entity.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private Long id;

    private Long shopId;

    private String categorySn;

    private String categotyName;

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

    public String getCategorySn() {
        return categorySn;
    }

    public void setCategorySn(String categorySn) {
        this.categorySn = categorySn == null ? null : categorySn.trim();
    }

    public String getCategotyName() {
        return categotyName;
    }

    public void setCategotyName(String categotyName) {
        this.categotyName = categotyName == null ? null : categotyName.trim();
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