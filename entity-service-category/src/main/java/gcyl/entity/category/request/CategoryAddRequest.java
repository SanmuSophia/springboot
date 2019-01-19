package gcyl.entity.category.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 类目新增参数
 *
 * @author lican
 * @date 2018/12/12
 */
public class CategoryAddRequest extends AbstractRequest {
    /**
     * 店铺ID
     */
    @NotNull(message = Message.SHOP_ID_NULL)
    private Long shopId;

    /**
     * 类目名
     */
    @NotEmpty(message = "请填写类目名")
    @Size(max = 15, message = "类目名过长")
    private String categoryName;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
