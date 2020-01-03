package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching   //添加缓存注解
@MapperScan("com.example.demo.dao")
public class SpringbootRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisCacheApplication.class, args);
	}

}
