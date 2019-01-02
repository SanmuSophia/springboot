package gcyl.entity.order.request;

import gcyl.entity.order.Enum.UListTypeEnum;

import javax.validation.constraints.NotNull;

/**
 * 用户订单列表请求参数
 *
 * @author lican
 * @date 2018/12/29
 */
public class OrderUListRequest {

    /**
     * 用户ID
     */
    @NotNull(message = "店铺信息有误")
    private Long userId;

    /**
     * 列表类型
     */
    @NotNull(message = "订单类型有误")
    private Integer listType;

    /**
     * 列表类型枚举(listType计算)
     */
    private UListTypeEnum typeEnum;

    /**
     * 页面大小
     */
    private int pageSize = 5;

    /**
     * 页码
     */
    private int pageNum = 1;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public UListTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(UListTypeEnum typeEnum) {
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
