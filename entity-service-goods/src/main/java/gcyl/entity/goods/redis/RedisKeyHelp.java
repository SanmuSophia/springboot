package gcyl.entity.goods.redis;


/**
 * redis key generator
 *
 * @author lican
 * @date 2018/8/2
 */
public class RedisKeyHelp {

    private static final String G_PREFIX = "entity:goods"; //商品

    private static final String C_PREFIX = "entity:cart";  //购物车

    /**
     * 用户个人购物车
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @return redis key
     */
    public static String getUserCartKey(long shopId, long tableNum, long userId) {
        return getTableCartKey(shopId, tableNum) + ":userId:" + userId;
    }

    /**
     * 餐桌购物车
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return redis key
     */
    public static String getTableCartKey(long shopId, long tableNum) {
        return C_PREFIX + ":shopId:" + shopId + ":tableNum:" + tableNum;
    }


}
