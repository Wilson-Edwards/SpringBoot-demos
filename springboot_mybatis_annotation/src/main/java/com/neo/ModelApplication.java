package com.neo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ModelApplication {

	public static void main(String[] args) {

		SpringApplication.run(ModelApplication.class, args);
		System.out.println("hello world!");
	}

}
