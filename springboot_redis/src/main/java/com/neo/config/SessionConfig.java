package com.neo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @program: springboot_redis->SessionConfig
 * @description: session配置类
 * @author: lin qx
 * @create: 2019-11-19 15:59
 **/
@Configuration
//存放session到redis上的注解，最大失效时间是session的失效时间，单位为秒
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {
}
