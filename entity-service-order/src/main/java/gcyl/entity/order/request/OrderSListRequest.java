package gcyl.entity.order.request;

import gcyl.entity.order.Enum.SListTypeEnum;

import javax.validation.constraints.NotNull;

/**
 * 店铺订单列表请求参数
 *
 * @author lican
 * @date 2018/12/29
 */
public class OrderSListRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = "店铺信息有误")
    private Long shopId;

    /**
     * 列表类型
     */
    @NotNull(message = "订单类型有误")
    private Integer listType;

    /**
     * 列表类型枚举(listType计算)
     */
    private SListTypeEnum typeEnum;

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

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public SListTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(SListTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
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
