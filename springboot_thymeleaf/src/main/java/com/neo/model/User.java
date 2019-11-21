package com.neo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: springboot_thymeleaf->User
 * @description: 用户类
 * @author: lin qx
 * @create: 2019-11-20 20:57
 **/
@Data
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private Integer age;
    private String pass;

    public User(){
        super();
    }

    public User(String name, Integer age, String pass){
        this.name = name;
        this.age = age;
        this.pass = pass;
    }

}
