package gcyl.entity.category.common;


/**
 * redis key generator
 *
 * @author lican
 * @date 2018/8/2
 */
public class RedisKeyHelp {

    private static final String C_PREFIX = "entity:category";  //类目

    /**
     * 获取店铺类目key
     */
    public static String getShopCategoryKey(Long shopId) {
        return C_PREFIX + ":shopId:" + shopId.toString();
    }

    /**
     * 获取类目key
     */
    public static String getCategoryKey(String categoryId) {
        return C_PREFIX + ":categoryId:" + categoryId;
    }

}
