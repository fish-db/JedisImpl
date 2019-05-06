package base;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class BaseTest {
    protected Jedis jedis;

    @Before
    public void init(){
        String host = "localhost";
        int port = 6379;
        jedis = new Jedis(host, port);
    }

    @Test
    public void isEnvOk(){
        jedis.ping();
    }
}
