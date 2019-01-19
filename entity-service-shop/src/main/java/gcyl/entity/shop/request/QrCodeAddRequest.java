package gcyl.entity.shop.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 二维码新增参数
 *
 * @author lican
 * @date 2019/1/17
 */
public class QrCodeAddRequest extends AbstractRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = Message.SHOP_ID_NULL)
    private Long shopId;

    /**
     * 桌号
     */
    @NotNull(message = "请输入桌号")
    private Integer tableNum;

    /**
     * 二维码图片
     */
    @NotEmpty(message = "二维码信息异常")
    private String qrCodeImg;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    public String getQrCodeImg() {
        return qrCodeImg;
    }

    public void setQrCodeImg(String qrCodeImg) {
        this.qrCodeImg = qrCodeImg;
    }
}
