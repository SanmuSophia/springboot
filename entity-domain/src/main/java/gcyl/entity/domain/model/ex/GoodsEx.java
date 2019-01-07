package gcyl.entity.domain.model.ex;

import gcyl.entity.domain.model.Goods;
import gcyl.entity.domain.model.GoodsSpec;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品拓展
 *
 * @author lican
 * @date 2018/12/18
 */
public class GoodsEx extends Goods {

    /**
     * 商品价格(规格最小价格)
     */
    private BigDecimal price;

    /**
     * 规格最少库存(判断是否部分售罄)
     */
    private Integer minSpecStock;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 规格数量
     */
    private Integer specNum;

    /**
     * 商品规格
     */
    private List<GoodsSpec> goodsSpecList;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getMinSpecStock() {
        return minSpecStock;
    }

    public void setMinSpecStock(Integer minSpecStock) {
        this.minSpecStock = minSpecStock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSpecNum() {
        return specNum;
    }

    public void setSpecNum(Integer specNum) {
        this.specNum = specNum;
    }

    public List<GoodsSpec> getGoodsSpecList() {
        return goodsSpecList;
    }

    public void setGoodsSpecList(List<GoodsSpec> goodsSpecList) {
        this.goodsSpecList = goodsSpecList;
    }
}
