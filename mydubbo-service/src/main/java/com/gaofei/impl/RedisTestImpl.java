package com.gaofei.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaofei.interf.RedisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by GaoQingming on 2017/12/8 0008.
 */
@Service
public class RedisTestImpl implements RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String toSave) {
        redisTemplate.opsForValue().set("test",toSave,20, TimeUnit.SECONDS);
        //如果下面直接写10是不可以的
        //java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        redisTemplate.opsForValue().set("myint","10");
        Long l = redisTemplate.opsForValue().increment("myint",2);
    }

    public Long add(int n) {
        //如果下面直接写10是不可以的
        //java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        redisTemplate.opsForValue().set("myint","10");
        //虽然上面存储的是10，但是仍然能够加2
        Long l = redisTemplate.opsForValue().increment("myint",2);
        return l;
    }

    public void hashTest() {
        Map<String,String> map = new HashMap<String, String>();
        map.put("field1","1");
        map.put("field2","2");
        map.put("field3","3");
        redisTemplate.opsForHash().putAll("hashtest",map);
        Long result = redisTemplate.opsForHash().increment("hashtest","field1",9L);
        System.out.println("hashTest 1 + 9 = " + result);
    }
}
