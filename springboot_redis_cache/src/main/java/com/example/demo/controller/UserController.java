package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: springboot_redis_cache->UserController
 * @description: 用户控制类
 * @author: lin qx
 * @create: 2020-01-01 11:46
 **/
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("saveUser")
    public void saveUser(User user) {
        userService.saveUser(user);
    }

    @GetMapping("listUser")
    public List<User> listUser() {
        return userService.listUser();
    }

    @GetMapping("getUser")
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @PutMapping("updateUser")
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("deleteUser")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

}
