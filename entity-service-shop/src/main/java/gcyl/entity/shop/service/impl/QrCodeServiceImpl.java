package gcyl.entity.shop.service.impl;

import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.domain.mapper.QrCodeMapper;
import gcyl.entity.domain.mapper.ex.QrCodeExtMapper;
import gcyl.entity.domain.model.QrCode;
import gcyl.entity.domain.model.QrCodeExample;
import gcyl.entity.shop.request.QrCodeAddRequest;
import gcyl.entity.shop.service.IQrCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 二维码管理
 *
 * @author lican
 * @date 2019/1/17
 */
@Slf4j
@Service
public class QrCodeServiceImpl implements IQrCodeService {

    @Autowired
    QrCodeMapper qrCodeMapper;
    @Autowired
    QrCodeExtMapper qrCodeExtMapper;

    /**
     * 新增
     *
     * @param request  二维码信息
     */
    @Override
    public Result add(QrCodeAddRequest request) {
        long shopId = request.getShopId();
        int tableNum = request.getTableNum();
        String qrCodeImg = request.getQrCodeImg();

        Result result = this.isQrCodeExist(shopId, tableNum);
        if (!result.isSuccess()) return result;

        QrCode qrCode = new QrCode();
        qrCode.setShopId(shopId);
        qrCode.setTableNum(tableNum);
        qrCode.setQrCodeImg(qrCodeImg);
        qrCode.setGmtCreate(DateUtils.getDateTime());

        int i = qrCodeMapper.insertSelective(qrCode);
        if (i <= 0) {
            log.error(ResultEnum.S1101.toString());
            result.error(ResultEnum.S1101);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 删除
     *
     * @param shopId     店铺ID
     * @param qrCodeIds  二维码ID
     */
    @Override
    public Result delete(long shopId, List<Long> qrCodeIds) {
        Result result = this.isShopQrCode(shopId, qrCodeIds);
        if (!result.isSuccess()) return result;

        QrCodeExample example = new QrCodeExample();
        example.createCriteria().andIdIn(qrCodeIds);
        int i = qrCodeMapper.deleteByExample(example);
        if (i <= 0) {
            log.error(ResultEnum.S3101.toString());
            result.error(ResultEnum.S3101);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 查询
     *
     * @param shopId 店铺ID
     */
    @Override
    public List<QrCode> select(long shopId) {
        QrCodeExample example = new QrCodeExample();
        example.createCriteria().andShopIdEqualTo(shopId);
        return qrCodeExtMapper.selectByExample(example);
    }

    /**
     * 判断是否店铺二维码
     *
     * @param shopId     店铺ID
     * @param qrCodeIds  二维码ID
     */
    private Result isShopQrCode(long shopId, List<Long> qrCodeIds) {
        QrCodeExample example = new QrCodeExample();
        example.createCriteria().andIdIn(qrCodeIds).andShopIdEqualTo(shopId);
        int count = qrCodeMapper.countByExample(example);

        Result result = new Result();
        if (count < qrCodeIds.size()) {
            log.info(ResultEnum.S0101.toString());
            result.error(ResultEnum.S0101);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 判断该桌号是否已有二维码
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     */
    private Result isQrCodeExist(long shopId, int tableNum) {
        QrCodeExample example = new QrCodeExample();
        example.createCriteria().andShopIdEqualTo(shopId).andTableNumEqualTo(tableNum);
        int count = qrCodeMapper.countByExample(example);

        Result result = new Result();
        if (count > 0) {
            log.info(ResultEnum.S0102.toString());
            result.error(ResultEnum.S0102);
            return result;
        }

        result.success();
        return result;
    }
}
