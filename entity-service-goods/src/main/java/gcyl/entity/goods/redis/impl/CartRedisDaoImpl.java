package gcyl.entity.goods.redis.impl;

import com.alibaba.fastjson.JSON;
import gcyl.entity.common.utils.JsonUtils;
import gcyl.entity.domain.model.form.CartForm;
import gcyl.entity.goods.redis.ICartRedisDao;
import gcyl.entity.goods.redis.RedisKeyHelp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 购物车redis
 * redis map 格式保存
 *
 *                   map
 *            规格ID     商品信息
 * redisKey   mapKey    mapValue
 *
 *
 * @author lican
 * @date 2018/12/24
 */
@Component
public class CartRedisDaoImpl implements ICartRedisDao {

    @Autowired
    JedisPool jedisPool;

    private static final int EXPIRE_TIME = 60*60; //秒，有效时间1小时

    /**
     * 获取餐桌购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return  购物车商品列表
     */
    @Override
    public List<CartForm> getTable(long shopId, long tableNum) {
        String key = RedisKeyHelp.getTableCartKey(shopId, tableNum);
        return this.getFromRedis(key);
    }

    /**
     * redis获取购物车商品
     * @param key redisKey
     * @return 商品列表
     */
    private List<CartForm> getFromRedis(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            List<String> values = jedis.hvals(key);
            if (values.size() <= 0) {
                return Collections.emptyList();
            }

            List<CartForm> list = new ArrayList<>();
            for (String value : values) {
                CartForm cartForm = JsonUtils.toBean(value, CartForm.class);
                list.add(cartForm);
            }
            return list;
        }
    }

    /**
     * 添加餐桌购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param num       商品数量
     * @param cartForm  商品参数
     * @return  大于0添加成功
     */
    @Override
    public void addTable(long shopId, long tableNum, int num, CartForm cartForm) {
        String key = RedisKeyHelp.getTableCartKey(shopId, tableNum);
        this.addToRedis(key, num, cartForm);
    }

    /**
     * 添加商品置redis
     *
     * @param key      key
     * @param num      数量
     * @param cartForm 商品信息
     */
    private void addToRedis(String key, int num, CartForm cartForm) {
        String field = cartForm.getSpecId().toString();
        String value;
        try (Jedis jedis = jedisPool.getResource()) {
            String oldValue = jedis.hget(key, field);
            //没有商品 数量默认，有则增加数量
            if (StringUtils.isBlank(oldValue)) {
                cartForm.setNum(num);
                value = JSON.toJSONString(cartForm);
            } else {
                //获取旧数量
                CartForm oldCartForm = JsonUtils.toBean(oldValue, CartForm.class);
                int oldNum = oldCartForm.getNum();
                //保存新数量
                oldCartForm.setNum(oldNum + num);
                value = JSON.toJSONString(oldCartForm);
            }
            jedis.hset(key, field, value);
            jedis.expire(key, EXPIRE_TIME);
        }
    }

    /**
     * 餐桌商品移除/减少
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param specId    商品规格ID
     * @param num       商品数量
     * @return  大于0移除成功
     */
    @Override
    public void removeTable(long shopId, long tableNum, long specId, int num) {
        String tableKey = RedisKeyHelp.getTableCartKey(shopId, tableNum);
        String field = String.valueOf(specId);
        this.removeRedis(tableKey, field, num); //餐桌购物车移除
    }

    /**
     * redis商品移除/减少
     *
     * @param key      key
     * @param field    filed(规格ID)
     * @param num      数量
     */
    private void removeRedis(String key, String field, int num) {
        try (Jedis jedis = jedisPool.getResource()) {
            //获取旧数量
            String oldValue = jedis.hget(key, field);
            if (StringUtils.isBlank(oldValue)) return;
            CartForm oldCartForm = JsonUtils.toBean(oldValue, CartForm.class);
            int oldNum = oldCartForm.getNum();

            //计算新数量，<=0直接从购物车移除商品，否则修改数量
            int newNum = oldNum - num;
            if (newNum <= 0) {
                jedis.hdel(key, field);
            } else {
                oldCartForm.setNum(num);
                String value = JSON.toJSONString(oldCartForm);
                jedis.hset(key, field, value);
            }
        }
    }

    /**
     * 清空购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @return 大于0清空成功
     */
    @Override
    public void clear(long shopId, long tableNum) {
        String tableKey = RedisKeyHelp.getTableCartKey(shopId, tableNum);
        try (Jedis jedis = jedisPool.getResource()) {
            //获取该餐桌所有用户的key
//            String pattern = tableKey + "*";
//            List<String> allKeys = this.keyScan(pattern, 1000);

//            allKeys.add(tableKey);
//            jedis.del(allKeys.toArray(new String[]{}));
            jedis.del(tableKey);
        }
    }

    /**
     * 获取用户购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @return  购物车商品列表
     */
//    @Override
//    public List<CartForm> getUser(long shopId, long tableNum, long userId) {
//        String key = RedisKeyHelp.getUserCartKey(shopId, tableNum, userId);
//        return this.getFromRedis(key);
//    }

    /**
     * 添加个人购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @param num       商品数量
     * @param cartForm  商品参数
     * @return  大于0添加成功
     */
//    @Override
//    public long addUser(long shopId, long tableNum, long userId, int num, CartForm cartForm) {
//        String key = RedisKeyHelp.getUserCartKey(shopId, tableNum, userId);
//        return addToRedis(key, num, cartForm);
//    }


    /**
     * 个人商品移除/减少
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @param specId    商品规格ID
     * @param num       商品数量
     * @return  大于0移除成功
     */
//    @Override
//    public long removeUser(long shopId, long tableNum, long userId, long specId, int num) {
//        String userKey = RedisKeyHelp.getUserCartKey(shopId, tableNum, userId);
//        String tableKey = RedisKeyHelp.getTableCartKey(shopId, tableNum);
//        String field = String.valueOf(specId);
//        long uResult =  removeRedis(userKey, field, num);  //个人购物车移除
//        long tResult =  removeRedis(tableKey, field, num); //餐桌购物车移除
//        return uResult & tResult;
//    }

    /**
     * 清空个人购物车
     *
     * @param shopId    店铺ID
     * @param tableNum  桌号
     * @param userId    用户ID
     * @return  大于0清空成功
     */
//    @Override
//    public long clearUser(long shopId, long tableNum, long userId) {
//        String userKey = RedisKeyHelp.getUserCartKey(shopId, tableNum, userId);
//        String tableKey = RedisKeyHelp.getTableCartKey(shopId, tableNum);
//        try (Jedis jedis = jedisPool.getResource()) {
//            Map<String, String> map =  jedis.hgetAll(userKey);
//            //删除个人购物车
//            long result = jedis.del(userKey);
//
//            //餐桌购物车商品数量减少
//            map.forEach((key, value) -> {
//                if (StringUtils.isNotBlank(value)) {
//                    CartForm oldCartForm = JsonUtils.toBean(value, CartForm.class);
//                    int num = oldCartForm.getNum();
//                    this.removeRedis(tableKey, key, num);
//                }
//            });
//
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }

    /**
     * redis key scan
     *
     * @param pattern  匹配规则
     * @param count    每次扫描数量(建议1000-10000)
     * @return 匹配的key
     */
//    private List<String> keyScan(String pattern, int count) {
//        List<String> list = new ArrayList<>();
//        ScanParams params = new ScanParams();
//        params.count(count);
//        params.match(pattern);
//        String cursor = ScanParams.SCAN_POINTER_START;
//
//        try (Jedis jedis = jedisPool.getResource()) {
//            do {
//                ScanResult<String> result = jedis.scan(cursor, params);
//                list.addAll(result.getResult());
//                cursor = result.getStringCursor();
//            } while (!"0".equals(cursor));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }
}
