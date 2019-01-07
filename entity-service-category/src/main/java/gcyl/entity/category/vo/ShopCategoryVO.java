package gcyl.entity.category.vo;

import gcyl.entity.domain.model.Category;

import java.util.List;

/**
 * 店铺类目
 *
 * @author lican
 * @date 2019/1/3
 */
public class ShopCategoryVO {

    /**
     * 店铺类目
     */
    private List<Category> categories;

    /**
     * 是否有默认商品
     */
    private boolean hasDefault;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public boolean getHasDefault() {
        return hasDefault;
    }

    public void setHasDefault(boolean hasDefault) {
        this.hasDefault = hasDefault;
    }
}
