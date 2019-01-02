package gcyl.entity.goods.vo;

import gcyl.entity.domain.model.ext.GoodsExt;

import java.util.List;

/**
 * @author lican
 * @date 2018/12/21
 */
public class GoodsManageVo {

    /**
     * 商品列表
     */
    private List<GoodsExt> goodsList;

    /**
     * 商品总数
     */
    private long total;

    public List<GoodsExt> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsExt> goodsList) {
        this.goodsList = goodsList;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
