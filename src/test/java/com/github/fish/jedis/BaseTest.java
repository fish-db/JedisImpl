package com.github.fish.jedis;

import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 配置基本环境
 */
public class BaseTest {
    // 这是Redis客户端默认监听的IP地址和端口号
    protected static String defaultHost = "localhost";
    protected static int defaultPort = 6379;

    protected static Jedis jedis;

    /**
     * 创建一个Redis实例
     */
    @BeforeClass
    public static void init(){
        jedis = new Jedis(defaultHost, defaultPort);
    }

    @Test
    public void isEnvOk(){
        jedis.ping();
    }
}
