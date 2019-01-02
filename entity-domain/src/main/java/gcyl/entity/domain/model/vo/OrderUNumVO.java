package gcyl.entity.domain.model.vo;

/**
 * 用户订单数量
 *
 * @author lican
 * @date 2018/12/29
 */
public class OrderUNumVO {

    /**
     * 所有订单
     */
    private int all;

    /**
     * 已下单
     */
    private int ordered;

    /**
     * 待付款
     */
    private int waitPay;

    /**
     * 待评价
     */
    private int waitEvaluate;

    /**
     * 退款
     */
    private int refund;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public int getWaitPay() {
        return waitPay;
    }

    public void setWaitPay(int waitPay) {
        this.waitPay = waitPay;
    }

    public int getWaitEvaluate() {
        return waitEvaluate;
    }

    public void setWaitEvaluate(int waitEvaluate) {
        this.waitEvaluate = waitEvaluate;
    }

    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }
}
