package gcyl.entity.domain.mapper.ex;

import gcyl.entity.domain.model.form.CartForm;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 购物车 mapper
 *
 * @author lican
 * @date 2018/12/25
 */
public interface CartMapper {


    /**
     * 根据规格ID查询
     *
     * @param specId  规格ID
     * @return 规格信息
     */
    CartForm selectBySpecId(long specId);

    /**
     * 根据条件查询
     *
     * @param paramMap  查询条件
     * @return 结果集
     */
    List<CartForm> selectByMap(Map<String, Object> paramMap);

    /**
     * 获取用户头像和昵称
     * @param userId  用户ID
     * @return 用户信息
     */
    @Select("select logo, nick_name as name " +
            "from tyg_user_list " +
            "where user_id = #{userId}")
    Map<String, Object> selectUserInfo(long userId);
}
