package com.lator.tricker.mylator.testInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisConTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/test")
    public String testRedis(){
        redisTemplate.opsForValue().set("xxx","zhangsan");
        String xxx = (String)redisTemplate.opsForValue().get("xxx");
        return xxx;
    }
}
