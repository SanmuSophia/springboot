package gcyl.entity.goods.vo;

import gcyl.entity.domain.model.form.CartForm;

import java.util.List;
import java.util.Map;

/**
 * 购物车详情
 *
 * @author lican
 * @date 2019/1/10
 */
public class CartVO {

    /**
     * 购物车商品
     */
    private Map<String, List<CartForm>> cartMap;

    /**
     * 默认商品
     */
    private Map<String, List<CartForm>> defaultMap;

    public Map<String, List<CartForm>> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<String, List<CartForm>> cartMap) {
        this.cartMap = cartMap;
    }

    public Map<String, List<CartForm>> getDefaultMap() {
        return defaultMap;
    }

    public void setDefaultMap(Map<String, List<CartForm>> defaultMap) {
        this.defaultMap = defaultMap;
    }
}
