package gcyl.entity.controller.config.redis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * @author lican
 * @date 2018/9/13
 */
@Configuration
public class RedisConfiguration {
    @Value("${spring.redis.database}")
    int database;
    @Value("${spring.redis.host}")
    String host;
    @Value("${spring.redis.port}")
    int port;
    @Value("${spring.redis.password}")
    String password;
    @Value("${spring.redis.timeout}")
    int timeout;
    @Value("${spring.redis.jedis.pool.max-active}")
    int maxActive;
    @Value("${spring.redis.jedis.pool.max-wait}")
    long maxWait;
    @Value("${spring.redis.jedis.pool.max-idle}")
    int maxIdle;
    @Value("${spring.redis.jedis.pool.min-idle}")
    int minIdle;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxActive);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWait);
        config.setMinIdle(minIdle);
        return new JedisPoolConfig();
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig) {
        return new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
    }

    @Bean(name = "redisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setDatabase(database);
        configuration.setHostName(host);
        configuration.setPort(port);
        configuration.setPassword(RedisPassword.of(password));

        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder builder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)JedisClientConfiguration.builder();
        builder.poolConfig(jedisPoolConfig);

        return new JedisConnectionFactory(configuration, builder.build());
    }

    @Bean
    public RedisTemplate redisTemplate(@Qualifier("redisConnectionFactory") JedisConnectionFactory factory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
}
