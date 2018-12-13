package gcyl.entity.category.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

/**
 * 类目删除参数
 *
 * @author lican
 * @date 2018/12/12
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDelRequest {

    /**
     * 类目ID
     */
    @NotNull(message = "类目信息有误")
    private Long categoryId;

    /**
     * 店铺ID
     */
    @NotNull(message = "店铺未登录")
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
