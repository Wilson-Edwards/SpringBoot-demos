package com.neo.mapper;

import com.neo.mapper.test2.User2Mapper;
import com.neo.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: springboot_mybatis_xml_multisource->User2MapperTest
 * @description: 测试类
 * @author: lin qx
 * @create: 2019-11-22 00:21
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class User2MapperTest {

    @Autowired
    private User2Mapper user2Mapper;

    @Test
    public void testGetOne() throws Exception {
        User user = user2Mapper.getOne(1L);
        Assert.assertEquals("aa", user.getName());
    }
}
