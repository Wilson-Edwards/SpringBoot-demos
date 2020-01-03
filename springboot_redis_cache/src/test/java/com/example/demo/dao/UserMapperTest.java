package com.example.demo.dao;

import com.example.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: springboot_redis_cache->UserMapperTest
 * @description: UserMapper接口的单元测试类
 * @author: lin qx
 * @create: 2020-01-01 20:26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    public void saveUserTest() throws Exception{
        //首先new出一个user来插入
        User user = new User();
        user.setId(4L);
        user.setName("dd");
        user.setAge(44);
        //执行插入方法
        userMapper.saveUser(user);
        //使用断言来测试
        Assert.assertEquals(4, userMapper.listUser().size());
    }

    @Test
    @Transactional
    public void listUserTest() throws Exception{
        Assert.assertEquals(3, userMapper.listUser().size());
    }

    @Test
    @Transactional
    public void getUserTest() throws Exception{
        Assert.assertEquals("aa", userMapper.getUser(1L).getName());
    }

    @Test
    @Transactional
    public void updateUserTest() throws Exception{
        //首先获取一个user对象来修改或者直接new一个user对象
        User user = userMapper.getUser(1L);
        user.setName("dd");
        //更新user
        userMapper.updateUser(user);
        //使用断言测试
        Assert.assertEquals("dd", userMapper.getUser(1L).getName());
    }

    @Test
    @Transactional
    public void deleteUserTest() throws Exception{
        userMapper.deleteUser(1L);
        Assert.assertEquals(2, userMapper.listUser().size());
    }
}
