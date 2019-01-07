package gcyl.entity.goods.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品规格新增参数
 *
 * @author lican
 * @date 2018/12/13
 */
public class SpecAddForm {

    /**
     * 规格类型
     */
    @NotNull(message = "规格信息有误")
    private String specKey;

    /**
     * 规格名
     */
    @NotNull(message = "请选择规格")
    private String specName;

    /**
     * 规格价格
     */
    @NotNull(message = "请填写价格")
    @Min(value = 0, message = "价格需大于0")
    private BigDecimal specPrice;

    /**
     * 规格日库存
     */
    @NotNull(message = "请填写日库存")
    @Min(value = 0, message = "日库存需大于0")
    private Integer specDayStock;

    public String getSpecKey() {
        return specKey;
    }

    public void setSpecKey(String specKey) {
        this.specKey = specKey;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public BigDecimal getSpecPrice() {
        return specPrice;
    }

    public void setSpecPrice(BigDecimal specPrice) {
        this.specPrice = specPrice;
    }

    public Integer getSpecDayStock() {
        return specDayStock;
    }

    public void setSpecDayStock(Integer specDayStock) {
        this.specDayStock = specDayStock;
    }
}
