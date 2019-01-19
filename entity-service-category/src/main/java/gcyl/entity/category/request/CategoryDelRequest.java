package gcyl.entity.category.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;

import javax.validation.constraints.NotNull;

/**
 * 类目删除参数
 *
 * @author lican
 * @date 2018/12/12
 */
public class CategoryDelRequest extends AbstractRequest {

    /**
     * 类目ID
     */
    @NotNull(message = Message.CATEGORY_ID_NULL)
    private Long categoryId;

    /**
     * 店铺ID
     */
    @NotNull(message = Message.SHOP_ID_NULL)
    private Long shopId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
