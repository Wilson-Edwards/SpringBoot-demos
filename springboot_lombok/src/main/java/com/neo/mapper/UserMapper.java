package com.neo.mapper;

import com.neo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: springboot_mybatis_xml->UserMapper
 * @description: 用户表的操作接口
 * @author: lin qx
 * @create: 2019-11-09 22:45
 **/
@Mapper
public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}