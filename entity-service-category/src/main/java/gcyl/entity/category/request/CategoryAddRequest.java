package gcyl.entity.category.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 类目新增参数
 *
 * @author lican
 * @date 2018/12/12
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryAddRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = "店铺未登录")
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