package com.neo.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

/**
 * @program: springboot_swagger->User
 * @description: 用户对象，与用户表对应
 * @author: lin qx
 * @create: 2019-11-17 19:06
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer age;

    public User(){
        super();
    }

    public User(String name, Integer age){
        super();
        this.name = name;
        this.age = age;
    }

}
