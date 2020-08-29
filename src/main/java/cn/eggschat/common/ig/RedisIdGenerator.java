package cn.eggschat.common.ig;

import org.nutz.integration.jedis.JedisAgent;
import org.nutz.integration.jedis.RedisService;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

@IocBean
public class RedisIdGenerator implements IdGenerator {

    @Inject
    protected RedisService redisService;

    @Override
    public String next(String tableName, String prefix) {
        String key = prefix.toUpperCase();
        if (key.length() > 16) {
            key = key.substring(0, 16);
        }
        String ym = Times.format("yyyyMM",new Date());
        String id = String.valueOf(redisService.incr("ig:" + tableName.toUpperCase() + ym));
        return key + ym + Strings.alignRight(id, 10, '0');
    }

    @Override
    public Object run(List<Object> fetchParam) {
        return next((String) fetchParam.get(0), (String) fetchParam.get(1));
    }

    @Override
    public String fetchSelf() {
        return "ig";
    }

}