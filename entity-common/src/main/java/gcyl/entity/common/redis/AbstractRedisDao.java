package gcyl.entity.common.redis;

import gcyl.entity.common.utils.GenericsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;

import javax.annotation.PostConstruct;

/**
 * Redis基类
 *
 * @author lican
 * @date 2018/9/19
 */
public class AbstractRedisDao<T> {

    @Autowired
    StringRedisTemplate template;

    protected Class entityClass;

    protected ValueOperations<String, String> valueOps;

    protected ListOperations<String, String> listOps;

    protected SetOperations<String, String> setOps;

    protected ZSetOperations<String, String> zSetOps;

    protected GeoOperations<String, String> geoOps;

    protected HyperLogLogOperations<String, String> hllOps;

    public AbstractRedisDao() {
        this.entityClass = GenericsUtils.getSuperClassGenericType(this.getClass());
    }

    @PostConstruct
    private void afterInitialization(){
        this.valueOps = this.template.opsForValue();
        this.setOps = this.template.opsForSet();
        this.zSetOps = this.template.opsForZSet();
        this.listOps = this.template.opsForList();
        this.geoOps = this.template.opsForGeo();
        this.hllOps = this.template.opsForHyperLogLog();
    }
}
