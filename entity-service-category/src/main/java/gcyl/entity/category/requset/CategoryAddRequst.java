package gcyl.entity.category.requset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

/**
 * 类目新增
 *
 * @author lican
 * @date 2018/12/12
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryAddRequst {

    /**
     * 店铺ID
     */
    @NotNull(message = "店铺未登录")
    private Long shopId;

    /**
     * 类目名
     */
}
