package com.neo.mapper;

import com.neo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: springboot_swagger->UserMapperTest
 * @description: 用户映射类的测试
 * @author: lin qx
 * @create: 2019-11-17 19:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception{
        userMapper.insert(new User("aa", 11));
        userMapper.insert(new User("bb", 22));
        userMapper.insert(new User("cc", 33));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testGetOne() throws Exception{
        User user = userMapper.getOne((long) 2);
        Assert.assertEquals("bb", user.getName());
    }

    @Test
    public void testGetAll() throws Exception{
        List<User> users = userMapper.getAll();

        Assert.assertEquals(3, users.size());
    }

    @Test
    public void testUpdate() throws Exception{
        User user = userMapper.getOne((long) 3);
        user.setName("dd");
        userMapper.update(user);
        Assert.assertTrue("dd".equals(userMapper.getOne((long) 3).getName()));
    }
}
