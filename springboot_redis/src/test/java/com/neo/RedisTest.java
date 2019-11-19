package com.neo;

import com.neo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @program: springboot_redis->RedisTest
 * @description: 测试Redis
 * @author: lin qx
 * @create: 2019-11-19 20:31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    //key-value都是String类型时使用，官方推荐
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    //key为String，value不是String时使用，RedisTenplate封装了Redis中的各种操作
    //详情见链接：https://www.jianshu.com/p/7bf5dc61ca06
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");  //对Redis中的字符串操作
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        //设置该key-value 1 秒后失效
        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
        //休眠 1 秒后查看是否还存在该key
        Thread.sleep(1000);
        //把判断条件放在一个boolean变量中，alibaba推荐
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        Assert.assertEquals(null, operations.get("com.neo.f"));
    }
}
