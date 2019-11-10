package com.neo.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @program: springboot_mybatis_xml->UserControllerTest
 * @description: UserController的单元测试类
 * @author: lin qx
 * @create: 2019-11-10 09:55
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMVc对象
    }

    @Test
    public void getUsers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/getUsers")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

}
