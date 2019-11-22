package com.neo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: springboot_swagger->User
 * @description: 用户类
 * @author: lin qx
 * @create: 2019-11-22 19:20
 **/
@Data
@ApiModel  //用来标识该类可以被swagger发现
public class User {

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户地址")
    private String address;

}

