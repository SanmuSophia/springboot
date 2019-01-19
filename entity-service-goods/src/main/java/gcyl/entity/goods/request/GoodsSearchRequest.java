package gcyl.entity.goods.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;
import gcyl.entity.goods.Enum.SortEnum;

import javax.validation.constraints.NotNull;

/**
 * 商品管理搜索参数
 *
 * @author lican
 * @date 2018/12/18
 */
public class GoodsSearchRequest extends AbstractRequest {
    /**
     * 店铺ID
     */
    @NotNull(message = Message.SHOP_ID_NULL)
    private Long shopId;

    /**
     * 售罄
     */
    private Boolean sellOut;

    /**
     * 店长推荐
     */
    private Boolean isRecommend;

    /**
     * 默认
     */
    private Boolean isDefault = false;

    /**
     * 热销
     */
    private Boolean hot;

    /**
     * 在售
     */
    private Boolean isOnSale;

    /**
     * 类目
     */
    private String categoryId;

    /**
     * 模糊搜索
     */
    private String likeValue;

    /**
     * 页码
     */
    private int pageNum = 1;

    /**
     * 页面大小
     */
    private int pageSize = 5;

    /**
     * 排序枚举
     */
    private SortEnum sortEnum = SortEnum.D;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Boolean getSellOut() {
        return sellOut;
    }

    public void setSellOut(Boolean sellOut) {
        this.sellOut = sellOut;
    }

    public Boolean getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(String likeValue) {
        this.likeValue = likeValue;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public SortEnum getSortEnum() {
        return sortEnum;
    }

    public void setSortEnum(SortEnum sortEnum) {
        this.sortEnum = sortEnum;
    }
}
