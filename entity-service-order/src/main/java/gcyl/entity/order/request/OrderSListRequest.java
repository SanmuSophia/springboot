package gcyl.entity.order.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.order.Enum.SListTypeEnum;

import javax.validation.constraints.NotNull;

/**
 * 店铺订单列表请求参数
 *
 * @author lican
 * @date 2018/12/29
 */
public class OrderSListRequest extends AbstractRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = "店铺信息有误")
    private Long shopId;

    /**
     * 列表类型枚举
     */
    private SListTypeEnum listType;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 页面大小
     */
    private int pageSize = 5;

    /**
     * 页码
     */
    private int pageNum = 1;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public SListTypeEnum getListType() {
        return listType;
    }

    public void setListType(SListTypeEnum listType) {
        this.listType = listType;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
