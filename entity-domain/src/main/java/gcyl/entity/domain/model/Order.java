package gcyl.entity.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {
    private Long orderId;

    private Long memberSponsorId;

    private Long shopIsponsorD;

    private Long shopId;

    private Long distributionShopId;

    private Byte identityTypes;

    private String identifier;

    private Long redPackageId;

    private String sponsorPaymentAccount;

    private Long orderNumber;

    private Long selectedAdressId;

    private BigDecimal shopCommodityTotalFigure;

    private BigDecimal commodityTotalFigure;

    private BigDecimal mailFee;

    private Byte isPay;

    private Byte getCommodityMethod;

    private Byte payMethod;

    private BigDecimal shopRealGetMoney;

    private BigDecimal realPayMoney;

    private Long confirmCode;

    private String leaveComment;

    private Byte payEnvironment;

    private Byte orderType;

    private Byte orderSource;

    private Long expectedArrivalTime;

    private Long acceptOrderFormTime;

    private Long createTime;

    private Long canleTime;

    private Long payTime;

    private Long strikeBargainTime;

    private Byte orderState;

    private Long sendCommodityTime;

    private String waybillNumber;

    private String logisticsCompany;

    private Byte offsetMode;

    private BigDecimal offsetFigure;

    private Byte sponsorGetWelfare;

    private BigDecimal sponsorGetWelfareFigure;

    private Byte chamberlainGetWelfare;

    private BigDecimal chamberlainWelfareFigure;

    private BigDecimal fullGetConsumerTicket;

    private BigDecimal serviceFee;

    private Byte isDelete;

    private Long deleteTime;

    private Long updateTime;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMemberSponsorId() {
        return memberSponsorId;
    }

    public void setMemberSponsorId(Long memberSponsorId) {
        this.memberSponsorId = memberSponsorId;
    }

    public Long getShopIsponsorD() {
        return shopIsponsorD;
    }

    public void setShopIsponsorD(Long shopIsponsorD) {
        this.shopIsponsorD = shopIsponsorD;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getDistributionShopId() {
        return distributionShopId;
    }

    public void setDistributionShopId(Long distributionShopId) {
        this.distributionShopId = distributionShopId;
    }

    public Byte getIdentityTypes() {
        return identityTypes;
    }

    public void setIdentityTypes(Byte identityTypes) {
        this.identityTypes = identityTypes;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    public Long getRedPackageId() {
        return redPackageId;
    }

    public void setRedPackageId(Long redPackageId) {
        this.redPackageId = redPackageId;
    }

    public String getSponsorPaymentAccount() {
        return sponsorPaymentAccount;
    }

    public void setSponsorPaymentAccount(String sponsorPaymentAccount) {
        this.sponsorPaymentAccount = sponsorPaymentAccount == null ? null : sponsorPaymentAccount.trim();
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getSelectedAdressId() {
        return selectedAdressId;
    }

    public void setSelectedAdressId(Long selectedAdressId) {
        this.selectedAdressId = selectedAdressId;
    }

    public BigDecimal getShopCommodityTotalFigure() {
        return shopCommodityTotalFigure;
    }

    public void setShopCommodityTotalFigure(BigDecimal shopCommodityTotalFigure) {
        this.shopCommodityTotalFigure = shopCommodityTotalFigure;
    }

    public BigDecimal getCommodityTotalFigure() {
        return commodityTotalFigure;
    }

    public void setCommodityTotalFigure(BigDecimal commodityTotalFigure) {
        this.commodityTotalFigure = commodityTotalFigure;
    }

    public BigDecimal getMailFee() {
        return mailFee;
    }

    public void setMailFee(BigDecimal mailFee) {
        this.mailFee = mailFee;
    }

    public Byte getIsPay() {
        return isPay;
    }

    public void setIsPay(Byte isPay) {
        this.isPay = isPay;
    }

    public Byte getGetCommodityMethod() {
        return getCommodityMethod;
    }

    public void setGetCommodityMethod(Byte getCommodityMethod) {
        this.getCommodityMethod = getCommodityMethod;
    }

    public Byte getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Byte payMethod) {
        this.payMethod = payMethod;
    }

    public BigDecimal getShopRealGetMoney() {
        return shopRealGetMoney;
    }

    public void setShopRealGetMoney(BigDecimal shopRealGetMoney) {
        this.shopRealGetMoney = shopRealGetMoney;
    }

    public BigDecimal getRealPayMoney() {
        return realPayMoney;
    }

    public void setRealPayMoney(BigDecimal realPayMoney) {
        this.realPayMoney = realPayMoney;
    }

    public Long getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(Long confirmCode) {
        this.confirmCode = confirmCode;
    }

    public String getLeaveComment() {
        return leaveComment;
    }

    public void setLeaveComment(String leaveComment) {
        this.leaveComment = leaveComment == null ? null : leaveComment.trim();
    }

    public Byte getPayEnvironment() {
        return payEnvironment;
    }

    public void setPayEnvironment(Byte payEnvironment) {
        this.payEnvironment = payEnvironment;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Byte orderSource) {
        this.orderSource = orderSource;
    }

    public Long getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public void setExpectedArrivalTime(Long expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }

    public Long getAcceptOrderFormTime() {
        return acceptOrderFormTime;
    }

    public void setAcceptOrderFormTime(Long acceptOrderFormTime) {
        this.acceptOrderFormTime = acceptOrderFormTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getCanleTime() {
        return canleTime;
    }

    public void setCanleTime(Long canleTime) {
        this.canleTime = canleTime;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getStrikeBargainTime() {
        return strikeBargainTime;
    }

    public void setStrikeBargainTime(Long strikeBargainTime) {
        this.strikeBargainTime = strikeBargainTime;
    }

    public Byte getOrderState() {
        return orderState;
    }

    public void setOrderState(Byte orderState) {
        this.orderState = orderState;
    }

    public Long getSendCommodityTime() {
        return sendCommodityTime;
    }

    public void setSendCommodityTime(Long sendCommodityTime) {
        this.sendCommodityTime = sendCommodityTime;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber == null ? null : waybillNumber.trim();
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany == null ? null : logisticsCompany.trim();
    }

    public Byte getOffsetMode() {
        return offsetMode;
    }

    public void setOffsetMode(Byte offsetMode) {
        this.offsetMode = offsetMode;
    }

    public BigDecimal getOffsetFigure() {
        return offsetFigure;
    }

    public void setOffsetFigure(BigDecimal offsetFigure) {
        this.offsetFigure = offsetFigure;
    }

    public Byte getSponsorGetWelfare() {
        return sponsorGetWelfare;
    }

    public void setSponsorGetWelfare(Byte sponsorGetWelfare) {
        this.sponsorGetWelfare = sponsorGetWelfare;
    }

    public BigDecimal getSponsorGetWelfareFigure() {
        return sponsorGetWelfareFigure;
    }

    public void setSponsorGetWelfareFigure(BigDecimal sponsorGetWelfareFigure) {
        this.sponsorGetWelfareFigure = sponsorGetWelfareFigure;
    }

    public Byte getChamberlainGetWelfare() {
        return chamberlainGetWelfare;
    }

    public void setChamberlainGetWelfare(Byte chamberlainGetWelfare) {
        this.chamberlainGetWelfare = chamberlainGetWelfare;
    }

    public BigDecimal getChamberlainWelfareFigure() {
        return chamberlainWelfareFigure;
    }

    public void setChamberlainWelfareFigure(BigDecimal chamberlainWelfareFigure) {
        this.chamberlainWelfareFigure = chamberlainWelfareFigure;
    }

    public BigDecimal getFullGetConsumerTicket() {
        return fullGetConsumerTicket;
    }

    public void setFullGetConsumerTicket(BigDecimal fullGetConsumerTicket) {
        this.fullGetConsumerTicket = fullGetConsumerTicket;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Long getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}