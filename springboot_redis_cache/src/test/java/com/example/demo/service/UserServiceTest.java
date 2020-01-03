package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: springboot_redis_cache->UserServiceTest
 * @description: UserService的测试类
 * @author: lin qx
 * @create: 2020-01-02 18:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void saveUserTest() throws Exception{
        User user = new User();
        user.setName("dd");
        user.setAge(55);
        userService.saveUser(user);
        Assert.assertEquals(4, userService.listUser().size());
    }

    @Test
    @Transactional
    public void listUserTest() throws Exception{
        Assert.assertEquals(3, userService.listUser().size());
    }

    @Test
    @Transactional
    public void getUserTest() throws Exception{
        Assert.assertEquals("aa", userService.getUser(1L).getName());
    }

    @Test
    @Transactional
    public void updateUserTest() throws Exception{
        //首先获取一个user对象来修改或者直接new一个user对象
        User user = userService.getUser(2L);
        user.setName("dd");
        //使用断言测试
        Assert.assertEquals("dd", userService.updateUser(user).getName());
    }

    @Test
    @Transactional
    public void deleteUserTest() throws Exception{
        userService.deleteUser(1L);
        Assert.assertEquals(2, userService.listUser().size());
    }

}
