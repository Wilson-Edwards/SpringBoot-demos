package com.neo.mapper.test2;

import com.neo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: springboot_mybatis_xml_multisource->User2Mapper
 * @description: 用户2的mapper类
 * @author: lin qx
 * @create: 2019-11-21 18:14
 **/
@Repository
public interface User2Mapper {

    void save(User user);

    List<User> listUser();

    User getOne(Long id);

    void update(User user);

    void delete(Long id);
}
