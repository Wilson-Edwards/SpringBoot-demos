package com.example.demo.service.serviceImp;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot_redis_cache->UserServiceImp
 * @description: UserService接口的实现类
 * @author: lin qx
 * @create: 2020-01-02 16:59
 **/
@Service
@CacheConfig(cacheNames="c1")
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void saveUser(User user){
        userMapper.saveUser(user);
    }

    @Override
    @Cacheable
    // 默认情况下缓存的key是方法参数，value是方法返回值
    public User getUser(Long id){
        return userMapper.getUser(id);
    }

    @Override
    public List<User> listUser(){
        return userMapper.listUser();
    }

    @Override
    @CachePut(key = "#user.getId()")
    public User updateUser(User user){
        userMapper.updateUser(user);
        return userMapper.getUser(user.getId());
    }

    @Override
    @CacheEvict
    public void deleteUser(Long id){
        userMapper.deleteUser(id);
    }


}
