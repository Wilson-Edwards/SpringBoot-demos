package com.neo.mapper.test1;

import com.neo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: springboot_mybatis_xml_multisource->User1Mapper
 * @description: 用户1的mapper类
 * @author: lin qx
 * @create: 2019-11-21 18:12
 **/
@Repository
public interface User1Mapper {

    void save(User user);

    List<User> listUser();

    User getOne();

    void update(User user);

    void delete(Long id);
}
