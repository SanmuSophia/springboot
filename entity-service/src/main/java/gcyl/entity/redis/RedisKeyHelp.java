package gcyl.entity.redis;


/**
 * redis key generator
 *
 * @author lican
 * @date 2018/8/2
 */
public class RedisKeyHelp {

    private static final String C_PREFIX = "entity:category";  //类目
    private static final String G_PREFIX = "entity:goods";     //商品
    private static final String O_PREFIX = "entity:order";     //订单

    /*******                       类目                         *******/

    /**
     * 获取店铺类目key
     */
    public static String getShopCategoryKey(Long shopId) {
        return C_PREFIX + ":shopId:" + shopId.toString();
    }


    /*******                       商品                         *******/



    /*******                       订单                         *******/
}
