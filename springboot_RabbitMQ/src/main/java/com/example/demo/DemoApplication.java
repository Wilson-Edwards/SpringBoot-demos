package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(AmqpTemplate template) {
		//lambda表达式，左边args为参数，右边为函数
		return args -> template.convertAndSend("myqueue", "foo");
	}

	@Bean
	public Queue myQueue() {
		//声明queue的名字
		return new Queue("myqueue");
	}

	/*
	回调函数，给消息队列回调该函数
	 */
	@RabbitListener(queues = "myqueue") //声明监听的队列
	public void listen(String in) {
		System.out.println(in);
	}

}
