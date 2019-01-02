package gcyl.entity.domain.model.vo;

/**
 * 店铺订单数量
 *
 * @author lican
 * @date 2018/12/29
 */
public class OrderSNumVO {

    /**
     * 待接单
     */
    private int waitReceive;

    /**
     * 待上菜
     */
    private int waitServing;

    /**
     * 待付款
     */
    private int waitPay;

    /**
     * 已完成
     */
    private int finish;

    /**
     * 已关闭
     */
    private int close;

    public int getWaitReceive() {
        return waitReceive;
    }

    public void setWaitReceive(int waitReceive) {
        this.waitReceive = waitReceive;
    }

    public int getWaitServing() {
        return waitServing;
    }

    public void setWaitServing(int waitServing) {
        this.waitServing = waitServing;
    }

    public int getWaitPay() {
        return waitPay;
    }

    public void setWaitPay(int waitPay) {
        this.waitPay = waitPay;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public int getClose() {
        return close;
    }

    public void setClose(int close) {
        this.close = close;
    }
}
