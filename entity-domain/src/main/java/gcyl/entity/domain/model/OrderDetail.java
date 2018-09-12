package gcyl.entity.domain.model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private Integer id;

    private String orderId;

    private String goodsId;

    private Long goodsDetailId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Long getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Long goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }
}