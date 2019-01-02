package gcyl.entity.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lican
 * @date 2018/12/27
 */
@Component
public class SnGenerate {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Autowired
    JedisPool jedisPool;

    /**
     * 编号生成
     * (编号前缀 + yyyyMMdd + 7位长度序列号)
     *
     * @param prefix 前缀
     * @return 编号
     */
    public String snGenerate(String prefix) {
        LocalDateTime dateTime = LocalDateTime.now();
        String date = dtf.format(dateTime);
        String key = prefix + date;
        Long num;
        try (Jedis jedis = jedisPool.getResource()) {
            num = jedis.incrBy(key, 1);
            long expireTime = DateUtils.getDateEndTime();
            if (num <= 1) {
                jedis.expireAt(key, expireTime);
            }
        }
        String s = StringUtils.leftPad(num.toString(), 7, "0");
        return key + s;
    }
}
