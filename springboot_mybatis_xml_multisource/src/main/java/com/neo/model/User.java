package com.neo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: springboot_mybatis_xml_multisource->User
 * @description: 用户类
 * @author: lin qx
 * @create: 2019-11-21 18:14
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer age;

    public User() {
        super();
    }

    public User(String name, Integer age){
        super();
        this.name = name;
        this.age = age;
    }
}
