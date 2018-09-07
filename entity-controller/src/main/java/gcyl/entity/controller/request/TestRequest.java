package gcyl.entity.controller.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lican
 * @date 2018/9/7
 */
@ApiModel(value = "request", description = "测试请求")
public class TestRequest {

    @ApiModelProperty(
            value = "goodsId",
            name = "商品ID",
            example = "G123465798")
    private String goodsId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
