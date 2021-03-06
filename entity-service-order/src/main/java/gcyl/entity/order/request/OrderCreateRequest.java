package gcyl.entity.order.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;
import gcyl.entity.order.form.SpecNumForm;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/**
 * 下单参数
 *
 * @author lican
 * @date 2018/12/27
 */
public class OrderCreateRequest extends AbstractRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = Message.SHOP_ID_NULL)
    private Long shopId;

    /**
     * 用户ID
     */
    @NotNull(message = Message.USER_ID_NULL)
    private Long userId;

    /**
     * 桌号
     */
    @NotNull(message = Message.TABLE_NUM_NULL)
    private Integer tableNum;

    /**
     * 支付方式
     */
    @NotNull(message = "支付方式异常")
    private Integer payWay;

    /**
     * 商品总价
     */
    @NotNull(message = "商品价格异常")
    @Min(value = 0, message = "商品价格有误")
    private BigDecimal goodsAmount;

    /**
     * 抵扣金额
     */
    @Min(value = 0, message = "抵扣金额有误")
    private BigDecimal deductAmount = new BigDecimal(0);

    /**
     * 抵扣方式
     */
    private int deductMethod = 0;

    /**
     * 赠送消费卷
     */
    @Min(value = 0, message = "赠送消费卷有误")
    private BigDecimal consumption = new BigDecimal(0);

    /**
     * 用户数量
     */
    @NotNull(message = "用户数量有误")
    @Min(value = 1, message = "用户数量有误")
    private Integer personNum;

    /**
     * 订单商品规格数量
     */
    @NotNull(message = "订单商品信息异常")
    @Size(min = 1, message = "订单商品信息有误")
    @Valid
    private List<SpecNumForm> specNumForms;

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

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
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

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public List<SpecNumForm> getSpecNumForms() {
        return specNumForms;
    }

    public void setSpecNumForms(List<SpecNumForm> specNumForms) {
        this.specNumForms = specNumForms;
    }
}
