package com.neo.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @program: springboot_mybatis_xml_multisource->UserControllerTest
 * @description: 用户测试类
 * @author: lin qx
 * @create: 2019-11-21 22:39
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        //初始化MockMvc对象
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @org.junit.Test
    @Transactional
    public void save() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/save")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void getOne() throws Exception{
        //执行URL
        mockMvc.perform(MockMvcRequestBuilders.get("/getOne")
                .param("id", "1")  //传入参数
                .accept(MediaType.APPLICATION_JSON))  //接受成JSON类型
                .andDo(print())   //打印结果
                .andExpect(status().isOk())   //期望返回状态值OK
                //期望返回的name是aa
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("aa"));
    }

    @Test
    @Transactional
    public void getUsers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/listUsers")
            .accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print());
    }



}
