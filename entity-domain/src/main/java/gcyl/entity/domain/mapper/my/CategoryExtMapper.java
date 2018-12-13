package gcyl.entity.domain.mapper.my;


import gcyl.entity.domain.model.Category;
import gcyl.entity.domain.model.CategoryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * category extend mapper
 * 只做需要字段的操作
 *
 * @author lican
 * @date 2018/10/8
 */
@Mapper
public interface CategoryExtMapper{

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Long id);

    /**
     * 判断店铺是否存在
     * @param shopId  店铺ID
     * @return true   店铺存在
     */
    @Select("select count(*) " +
            "from tyg_shop_list " +
            "where shop_id = #{shopId} " +
            "and cut_off = 0")
    boolean countShop(long shopId);
}

