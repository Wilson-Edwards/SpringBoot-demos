package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @program: springboot_redis_cache->UserMapper
 * @description: 用户类的操作接口
 * @author: lin qx
 * @create: 2020-01-01 11:45
 **/
@Mapper
public interface UserMapper {

    void saveUser(User user);

    User getUser(Long id);

    List<User> listUser();

    void updateUser(User user);

    void deleteUser(Long id);
}
