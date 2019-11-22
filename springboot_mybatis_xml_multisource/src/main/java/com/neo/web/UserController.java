package com.neo.web;

import com.neo.mapper.test1.User1Mapper;
import com.neo.mapper.test2.User2Mapper;
import com.neo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springboot_mybatis_xml_multisource->UserController
 * @description: 实现读写分离，主从同步
 * @author: lin qx
 * @create: 2019-11-21 18:14
 **/
@RestController
public class UserController {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(User user) {
        user1Mapper.save(user);
        user2Mapper.save(user);
        return "success";
    }

    @RequestMapping("/listUsers")
    public List<User> listUser() {
        List<User> users = user2Mapper.listUser();
        return users;
    }

    @RequestMapping("/getOne")
    public User getOne( Long id) {
        User user = user2Mapper.getOne(id);
        return user;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(User user){
        user1Mapper.update(user);
        user2Mapper.update(user);
        return "success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(Long id){
        user1Mapper.delete(id);
        user2Mapper.delete(id);
        return "success";
    }


}
