package gcyl.entity.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Spec implements Serializable {
    private Long id;

    private Long parentId;

    private String specName;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
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