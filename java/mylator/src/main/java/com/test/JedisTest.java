package com.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.10.128",6379);
        String ping = jedis.ping();
        System.out.println(ping);
    }
    @Test
    public void demo1(){
        Jedis jedis=new Jedis("192.168.10.128",6379);
        //设置
        jedis.set("name","zhangsan");
        String name = jedis.get("name");
        System.out.println(name);
        Set<String> keys=jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
