package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: springboot_redis_cache->User
 * @description: 用户类
 * @author: lin qx
 * @create: 2020-01-01 11:45
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer age;


}
