package com.example.demo.controller;


import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static com.mysql.cj.conf.PropertyKey.logger;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * @program: springboot_redis_cache->UserControllerTest
 * @description: UserController类的集成测试
 * @author: lin qx
 * @create: 2020-01-01 20:28
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @Transactional
    public void saveUserTest() throws Exception {
        //执行perform请求
        mockMvc.perform(post("/saveUser")
                .param("name", "dd")
                .param("age", "44")
        )
                .andExpect(status().isOk())
                .andDo(print());
        //检测
        mockMvc.perform(get("/listUser"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("dd")));
    }

    @Test
    @Transactional
    public void getUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getUser")
                .param("id", "1")
                .accept(MediaType.APPLICATION_JSON)//执行URL请求
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("aa"));
    }

    @Test
    @Transactional
    public void listUserTest() throws Exception {
        //使用MvcResult接收返回的数据
        MvcResult mvcResult =  mockMvc.perform(get("/listUser"))
                .andExpect(status().isOk())
                .andReturn();
        //将数据转换为JSONArray
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Content of Response:\n" + content);
        JSONArray jsonArray = new JSONArray(content);
        System.out.println("JSONArray\n" + jsonArray);
        Assert.assertEquals(jsonArray.length(), 3);
    }

    @Test
    @Transactional
    public void updateUserTest() throws Exception {
        mockMvc.perform(put("/updateUser")
                .param("id", "3")
                .param("name", "ee")
                .param("age", "55")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("ee"));
    }

    @Test
    @Transactional
    public void deleteUserTest() throws Exception {
        //先删除一个对象
        mockMvc.perform(delete("/deleteUser")
                .param("id", "2"));
        //然后获取该id对应的对象，会发现为空
        MvcResult mvcResult = mockMvc.perform(get("/getUser")
                .param("id", "2")
        )
                .andReturn();
        //断言
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("", content);

    }

}
