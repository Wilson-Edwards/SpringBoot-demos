package com.neo.web;

import com.neo.mapper.UserMapper;
import com.neo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springboot_mybatis_xml->UserController
 * @description: 用户类的Web接口
 * @author: lin qx
 * @create: 2019-11-09 22:50
 **/
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers(Long id) {
        List<User> users =userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user){
        userMapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user){
        userMapper.update(user);
    }

    @RequestMapping(value = "delete/{id}")
    public void delete (@PathVariable("id") Long id){
        userMapper.delete(id);
    }
}
