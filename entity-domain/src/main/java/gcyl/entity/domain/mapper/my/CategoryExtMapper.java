package gcyl.entity.domain.mapper.my;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lican
 * @date 2018/10/8
 */
@Mapper
public interface CategoryExtMapper{

    @Select("select count(*) from tyg_ms_category")
    int count();
}

