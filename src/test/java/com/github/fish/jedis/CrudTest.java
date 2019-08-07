package com.github.fish.jedis;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * 基本操作
 */
public class CrudTest extends BaseTest {
    /**
     * 插入一个记录
     */
    @Test
    public void string(){
        String key = "user:0002:name";
        String value = "Jon Snow";

        // 向数据库中插入一个值
        jedis.set(key, value);
        // 然后获得它的值
        String res = jedis.get(key);

        System.out.println(res);
        Assert.assertEquals(value, res);
    }

    /**
     * 获得所有的user开头的key
     */
    @Test
    public void keys(){
        Set<String> keys = jedis.keys("user*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    /**
     * 对list的操作
     */
    @Test
    public void list() {
        jedis.lpush("list1", "a", "b", "c", "d");

        for (int i = 0; i < 4; i++) {
            System.out.println(jedis.lpop("list1"));
        }
    }

    /**
     * 对set的操作
     */
    @Test
    public void set() {
        // 向set1插入a、b两个元素
        jedis.sadd("set1", "a", "b");

        // 获得set1中的元素个数
        System.out.println(jedis.scard("set1"));

        jedis.sadd("set2", "a", "b", "c");
        for (String ele : jedis.smembers("set2")){
            System.out.println(ele);
        }

        // 获得两个set的交集
        Set<String> interSet = jedis.sinter("set1", "set2");
        for (String ele : interSet){
            System.out.println(ele);
        }
    }

    /**
     * 集合的操作
     */
    @Test
    public void hash(){
        jedis.hset("plays", "player1", "Jon Snow");

        String player1 = jedis.hget("plays", "player1");

        System.out.println(player1);
    }
}
