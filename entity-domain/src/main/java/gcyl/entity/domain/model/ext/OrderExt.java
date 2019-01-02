package gcyl.entity.domain.model.ext;

import gcyl.entity.domain.model.Order;
import gcyl.entity.domain.model.form.OrderGoodsForm;

import java.util.List;

/**
 * 订单拓展
 *
 * @author lican
 * @date 2018/12/28
 */
public class OrderExt extends Order {

    /**
     * 商品图片列表
     */
    private List<String> images;

    /**
     * 订单商品
     */
    private List<OrderGoodsForm> goods;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<OrderGoodsForm> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderGoodsForm> goods) {
        this.goods = goods;
    }
}
