package com.github.fish.jedis;

import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 配置基本环境
 */
public class BaseTest {
    protected static String defaultHost = "localhost";
    protected static int defaultPort = 6379;

    protected static Jedis jedis;

    @BeforeClass
    public static void init(){
        jedis = new Jedis(defaultHost, defaultPort);
    }

    @Test
    public void isEnvOk(){
        jedis.ping();
    }
}
