package gcyl.entity.controller.goods;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.SpecKey;
import gcyl.entity.domain.model.SpecValue;
import gcyl.entity.goods.service.ISpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 规格管理
 *
 * @author lican
 * @date 2019/1/3
 */
@RestController
@RequestMapping("/spec")
public class SpecController {

    @Autowired
    ISpecService specService;

    /**
     * 规格键
     */
    @GetMapping(value = "/specKeys")
    public Result specKeys() {
        Result result = new Result();
        List<SpecKey> specKeys = specService.specKeys();
        result.success(specKeys);
        return result;
    }

    /**
     * 规格键
     */
    @GetMapping(value = "/specValues")
    public Result specValues(Long keyId) {
        Result result = new Result();
        if (keyId == null) {
            result.error("规格信息异常");
            return result;
        }

        List<SpecValue> specValues = specService.specValues(keyId);
        result.success(specValues);
        return result;
    }

}
