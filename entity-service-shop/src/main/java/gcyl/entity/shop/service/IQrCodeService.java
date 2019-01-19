package gcyl.entity.shop.service;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.QrCode;
import gcyl.entity.shop.request.QrCodeAddRequest;

import java.util.List;

/**
 * 二维码管理
 *
 * @author lican
 * @date 2019/1/17
 */
public interface IQrCodeService {

    /**
     * 新增
     *
     * @param request  二维码信息
     */
    Result add(QrCodeAddRequest request);

    /**
     * 删除
     *
     * @param shopId     店铺ID
     * @param qrCodeIds  二维码ID
     */
    Result delete(long shopId, List<Long> qrCodeIds);

    /**
     * 查询
     *
     * @param shopId 店铺ID
     */
    List<QrCode> select(long shopId);
}
