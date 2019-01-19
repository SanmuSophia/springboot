package gcyl.entity.controller.shop;

import gcyl.entity.common.annotation.ShopLogin;
import gcyl.entity.common.constant.Message;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.QrCode;
import gcyl.entity.shop.request.QrCodeAddRequest;
import gcyl.entity.shop.request.QrCodeDelRequest;
import gcyl.entity.shop.service.IQrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 二维码管理
 *
 * @author lican
 * @date 2019/1/17
 */
@Controller
@RequestMapping("/qrCode")
public class QrCodeController {

    @Autowired
    IQrCodeService qrCodeService;

    /**
     * 新增
     */
    @ShopLogin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@Valid @RequestBody QrCodeAddRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }
        return qrCodeService.add(request);
    }

    /**
     * 删除
     */
    @ShopLogin
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@Valid @RequestBody QrCodeDelRequest request, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return result;
        }
        long shopId = request.getShopId();
        List<Long> qrCodeIds = request.getQrCodeIds();
        return qrCodeService.delete(shopId, qrCodeIds);
    }

    /**
     * 查询
     */
    @ShopLogin
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public Result select(Long shopId) {
        Result result = new Result();
        if (shopId == null) {
            result.error(Message.SHOP_ID_NULL);
            return result;
        }
        List<QrCode> qrCodes = qrCodeService.select(shopId);
        result.success(qrCodes);
        return result;
    }
}
