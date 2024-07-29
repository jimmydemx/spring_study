package com.study.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SpringDataRedisTest {


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void  testRedisTemplate(){
        System.out.println(redisTemplate);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        HashOperations hashOperations = redisTemplate.opsForHash();
        ListOperations listOperations = redisTemplate.opsForList();
        SetOperations setOperations = redisTemplate.opsForSet();
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();


    }


    @Test
    public void testString(){
        // set get setex setnx
        redisTemplate.opsForValue().set("city","beijing");
        String city= (String)redisTemplate.opsForValue().get("city");
        System.out.println(city);
        redisTemplate.opsForValue().set("code","1234",3, TimeUnit.MINUTES);
        redisTemplate.opsForValue().setIfAbsent("lock","1");
        redisTemplate.opsForValue().setIfAbsent("lock","2"); // 设置不成功

        //
    }

    @Test
    public void testHash(){
        // hset hget hdel hkeys hvals
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("100", "name","tom");
        hashOperations.put("100","age","20");
        String name = (String) hashOperations.get("100", "name");
        System.out.println(name);

        Set keys = hashOperations.keys("100");
        System.out.println(keys);

        List values = hashOperations.values("100");
        System.out.println(values);

        hashOperations.delete("100","name");

    }

    @Test
    public void testList(){
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPushAll("mylist","a","b","c");
        listOperations.leftPush("mylist","d");
        List mylist= listOperations.range("mylist",0,-1);
        System.out.println(mylist);
        listOperations.rightPop("mylist");
        Long size = listOperations.size("mylist");
        System.out.println(size);
    }


    @Test
    public void testSet(){
        // saddd, smembers, scard sinter sunion srem
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","a","b","c","d");
        setOperations.add("set2","a","b","x","y");

        Set members = setOperations.members("set1");
        System.out.println(members);

        Long size = setOperations.size("set1");
        System.out.println(size);

        Set intersect= setOperations.intersect("set1","set2");
        System.out.println(intersect);


        Set union= setOperations.union("set1","set2");
        System.out.println(union);

        setOperations.remove("set1","a","b");


    }



}
