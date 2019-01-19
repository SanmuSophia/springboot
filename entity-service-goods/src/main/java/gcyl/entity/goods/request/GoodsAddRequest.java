package gcyl.entity.goods.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;
import gcyl.entity.goods.form.SpecAddForm;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 商品新增参数
 *
 * @author lican
 * @date 2018/12/13
 */
public class GoodsAddRequest extends AbstractRequest {
    /**
     * 店铺ID
     */
    @NotNull(message = Message.SHOP_ID_NULL)
    private Long shopId;

    /**
     * 商品名
     */
    @NotEmpty(message = "请填写商品名")
    private String goodsName;

    /**
     * 商品图片
     */
    @NotEmpty(message = "请上传商品图片")
    private String image;

    /**
     * 类目ID
     */
    @NotNull(message = "请选择类目")
    private Long categoryId;

    /**
     * 单位
     */
    @NotEmpty(message = "请选择单位")
    private String unit;


    /**
     * 店长推荐
     */
    @NotNull(message = "店长推荐信息异常")
    private Boolean isRecommend;

    /**
     * 默认商品
     */
    @NotNull(message = "默认商品信息异常")
    private Boolean isDefault;

    /**
     * 是否在售
     */
    @NotNull(message = "商品在售信息异常")
    private Boolean isOnSale;

    /**
     * 商品规格
     */
    @NotNull(message = "请填写商品详细信息")
    @Size(max = 8, message = "商品规格最多8个")
    @Valid
    private List<SpecAddForm> specAddForms;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<SpecAddForm> getSpecAddForms() {
        return specAddForms;
    }

    public void setSpecAddForms(List<SpecAddForm> specAddForms) {
        this.specAddForms = specAddForms;
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

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

}
