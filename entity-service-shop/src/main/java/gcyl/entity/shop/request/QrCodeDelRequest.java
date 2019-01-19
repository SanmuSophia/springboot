package gcyl.entity.shop.request;

import gcyl.entity.common.base.AbstractRequest;
import gcyl.entity.common.constant.Message;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 二维码删除参数
 *
 * @author lican
 * @date 2019/1/17
 */
public class QrCodeDelRequest extends AbstractRequest {

    /**
     * 店铺ID
     */
    @NotNull(message = Message.SHOP_ID_NULL)
    private Long shopId;

    /**
     * 二维码ID
     */
    @NotNull(message = Message.QR_CODE_ID_NULL)
    @Size(min = 1, message = "二维码信息有误")
    private List<Long> qrCodeIds;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public List<Long> getQrCodeIds() {
        return qrCodeIds;
    }

    public void setQrCodeIds(List<Long> qrCodeIds) {
        this.qrCodeIds = qrCodeIds;
    }
}
