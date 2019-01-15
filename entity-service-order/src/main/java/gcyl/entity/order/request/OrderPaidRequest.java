package gcyl.entity.order.request;

import gcyl.entity.common.base.AbstractRequest;

import javax.validation.constraints.NotNull;

/**
 * 支付完成请求
 *
 * @author lican
 * @date 2019/1/11
 */
public class OrderPaidRequest extends AbstractRequest {
    /**
     * 订单ID
     */
    @NotNull(message = "订单信息有误")
    private Long orderId;

    /**
     * 支付方式 参考PayMethodEnum
     */
    @NotNull(message = "支付方式有误")
    private Integer payMethod;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }
}
