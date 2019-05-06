package string;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class StringTest extends BaseTest {
    @Test
    public void crud(){
        String key = "user:0001:name";
        String value = "Jon Snow";
        jedis.set(key, value);
        String res = jedis.get(key);
        Assert.assertEquals(value, res);
    }
}
