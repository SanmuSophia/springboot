package gcyl.entity.goods.vo;

import gcyl.entity.domain.model.ex.GoodsEx;

import java.util.List;

/**
 * @author lican
 * @date 2018/12/21
 */
public class GoodsManageVo {

    /**
     * 商品列表
     */
    private List<GoodsEx> goodsList;

    /**
     * 商品总数
     */
    private long total;

    public List<GoodsEx> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsEx> goodsList) {
        this.goodsList = goodsList;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
