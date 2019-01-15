package gcyl.entity.controller.goods;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.SpecKey;
import gcyl.entity.domain.model.SpecValue;
import gcyl.entity.goods.service.ISpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 规格管理
 *
 * @author lican
 * @date 2019/1/3
 */
@Controller
@RequestMapping("/spec")
public class SpecController {

    @Autowired
    ISpecService specService;

    /**
     * 规格键
     */
    @RequestMapping(value = "/specKeys", method = RequestMethod.GET)
    @ResponseBody
    public Result specKeys() {
        Result result = new Result();
        List<SpecKey> specKeys = specService.specKeys();
        result.success(specKeys);
        return result;
    }

    /**
     * 规格键
     */
    @RequestMapping(value = "/specValues", method = RequestMethod.GET)
    @ResponseBody
    public Result specValues(Long keyId) {
        Result result = new Result();
        if (keyId == null) {
            result.error("规格信息有误");
            return result;
        }

        List<SpecValue> specValues = specService.specValues(keyId);
        result.success(specValues);
        return result;
    }

}
