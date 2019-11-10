package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@MapperScan("com.neo.mapper")
public class SpringbootMybatisXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisXmlApplication.class, args);
	}

}
