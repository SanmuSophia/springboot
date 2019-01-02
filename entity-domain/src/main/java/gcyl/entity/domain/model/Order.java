package gcyl.entity.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Order implements Serializable {
    private Long id;

    private String orderSn;

    private Integer orderState;

    private Boolean isPay;

    private Integer payMethod;

    private Integer payWay;

    private Long shopId;

    private Long userId;

    private Integer tableNum;

    private BigDecimal consumeAmount;

    private BigDecimal settleAmount;

    private BigDecimal deductAmount;

    private Integer deductMethod;

    private BigDecimal consumption;

    private String description;

    private Integer personNum;

    private Date gmtCreate;

    private Date gmtModify;

    private Date gmtReceive;

    private Date gmtPay;

    private Date gmtServingFinish;

    private Date gmtFinish;

    private Boolean shopCutOff;

    private Boolean userCutOff;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Boolean getIsPay() {
        return isPay;
    }

    public void setIsPay(Boolean isPay) {
        this.isPay = isPay;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    public BigDecimal getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(BigDecimal consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    public BigDecimal getDeductAmount() {
        return deductAmount;
    }

    public void setDeductAmount(BigDecimal deductAmount) {
        this.deductAmount = deductAmount;
    }

    public Integer getDeductMethod() {
        return deductMethod;
    }

    public void setDeductMethod(Integer deductMethod) {
        this.deductMethod = deductMethod;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
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

    public Date getGmtReceive() {
        return gmtReceive;
    }

    public void setGmtReceive(Date gmtReceive) {
        this.gmtReceive = gmtReceive;
    }

    public Date getGmtPay() {
        return gmtPay;
    }

    public void setGmtPay(Date gmtPay) {
        this.gmtPay = gmtPay;
    }

    public Date getGmtServingFinish() {
        return gmtServingFinish;
    }

    public void setGmtServingFinish(Date gmtServingFinish) {
        this.gmtServingFinish = gmtServingFinish;
    }

    public Date getGmtFinish() {
        return gmtFinish;
    }

    public void setGmtFinish(Date gmtFinish) {
        this.gmtFinish = gmtFinish;
    }

    public Boolean getShopCutOff() {
        return shopCutOff;
    }

    public void setShopCutOff(Boolean shopCutOff) {
        this.shopCutOff = shopCutOff;
    }

    public Boolean getUserCutOff() {
        return userCutOff;
    }

    public void setUserCutOff(Boolean userCutOff) {
        this.userCutOff = userCutOff;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", orderState=").append(orderState);
        sb.append(", isPay=").append(isPay);
        sb.append(", payMethod=").append(payMethod);
        sb.append(", payWay=").append(payWay);
        sb.append(", shopId=").append(shopId);
        sb.append(", userId=").append(userId);
        sb.append(", tableNum=").append(tableNum);
        sb.append(", consumeAmount=").append(consumeAmount);
        sb.append(", settleAmount=").append(settleAmount);
        sb.append(", deductAmount=").append(deductAmount);
        sb.append(", deductMethod=").append(deductMethod);
        sb.append(", consumption=").append(consumption);
        sb.append(", description=").append(description);
        sb.append(", personNum=").append(personNum);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append(", gmtReceive=").append(gmtReceive);
        sb.append(", gmtPay=").append(gmtPay);
        sb.append(", gmtServingFinish=").append(gmtServingFinish);
        sb.append(", gmtFinish=").append(gmtFinish);
        sb.append(", shopCutOff=").append(shopCutOff);
        sb.append(", userCutOff=").append(userCutOff);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}