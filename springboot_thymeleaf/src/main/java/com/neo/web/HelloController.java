package com.neo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springboot_thymeleaf->HelloController
 * @description: hello的控制类
 * @author: lin qx
 * @create: 2019-11-20 20:58
 **/
@Controller //此次由于使用了页面，所以改为Controller注解
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("message", "http://www.ityouknow.com");
        return "hello";
    }
}
