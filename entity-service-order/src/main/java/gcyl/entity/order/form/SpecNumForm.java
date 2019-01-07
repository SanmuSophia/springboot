package gcyl.entity.order.form;

import javax.validation.constraints.NotNull;

/**
 * 规格-数量
 *
 * @author lican
 * @date 2019/1/3
 */
public class SpecNumForm {

    /**
     * 商品规格ID
     */
    @NotNull(message = "商品规格信息有误")
    private Long specId;

    /**
     * 规格数量
     */
    @NotNull(message = "商品数量有误")
    private Integer num;

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
