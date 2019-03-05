package gcyl.entity.controller.goods;

import gcyl.entity.common.result.Result;
import gcyl.entity.domain.model.Unit;
import gcyl.entity.goods.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单位管理
 *
 * @author lican
 * @date 2019/1/3
 */
@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    IUnitService unitService;

    /**
     * 所有单位
     */
    @GetMapping(value = "/units")
    public Result units() {
        Result result = new Result();
        List<Unit> units = unitService.units();
        result.success(units);
        return result;
    }
}
