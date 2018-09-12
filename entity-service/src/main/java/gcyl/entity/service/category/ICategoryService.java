package gcyl.entity.service.category;

import gcyl.entity.domain.model.Category;

/**
 * 类目
 *
 * @author lican
 * @date 2018/9/11
 */
public interface ICategoryService {

    Category add(long shopId, String categoryName);
}
