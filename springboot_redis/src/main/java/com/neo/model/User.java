package com.neo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: springboot_redis->User
 * @description: 用户类
 * @author: lin qx
 * @create: 2019-11-19 15:58
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String nickname;
    private String regTime;

    public User(){ //在领域模型中定义有参构造方法时必须也定义无参构造方法
        super();
    }

    public User(String email, String nickname, String password, String userName, String regTime){
        super();
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userName = userName;
        this.regTime = regTime;
    }

}
