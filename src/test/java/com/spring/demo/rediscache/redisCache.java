package com.spring.demo.rediscache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.demo.entity.otherUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisCache {
    public static void main(String[] args) {

    }


    @Test
    public void test() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());

    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        //ops开头的操作所有的数据类型
        redisTemplate.opsForValue().set("mykey", "吴朝大傻逼");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }
    @Test
    public void test2() throws JsonProcessingException {
        otherUser otherUser=new otherUser("wuzhao","mjl");
        //jason序列化

     String user=new ObjectMapper().writeValueAsString(otherUser);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
