package com.github.fish.jedis;

import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Redis 连接池
 */
public class PoolTest extends BaseTest {
    protected static JedisPool jedisPool;

    /**
     * 创建一个连接池
     */
    @BeforeClass
    public static void initPool(){
        jedisPool = new JedisPool(defaultHost, defaultPort);
    }

    @Test
    public void isEnvOk(){
        // 从连接池中获得一个Redis连接
        Jedis jedis1 = jedisPool.getResource();
        jedis1.ping();

        // 输出所有的key
        Set<String> keys = jedis1.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
