package com.neo.controller;

import com.neo.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springboot_swagger->UserController
 * @description: 用户控制类
 * @author: lin qx
 * @create: 2019-11-22 19:08
 **/
@RestController
@Api(tags = "用户管理接口")
@RequestMapping("/user")
public class UserController {

    @ApiOperation("根据id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99")
    })
    @GetMapping("/")
    public User getUserById(Long id){
        User user = new User();
        user.setId(id);
        return user;
    }

    @ApiOperation("根据id更新用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99"),
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "aa")
    })
    @PutMapping("/")
    public User UpdateUsernameById(String username, Long id){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    @ApiOperation("添加用户")
    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return user;
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){

    }

}
