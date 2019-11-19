package com.neo.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @program: springboot_redis->RedisConfig
 * @description: redis的配置类
 * @author: lin qx
 * @create: 2019-11-19 15:58
 **/
@Configuration   //配置类注解
@EnableCaching    //启用缓存
public class RedisConfig extends CachingConfigurerSupport{

    @Bean
    @Override
    public KeyGenerator keyGenerator(){ //根据一个字符串生成密钥
        return new KeyGenerator(){
            @Override
            /**
             * 生成密钥
             * @Param target  目标类
             * @Param method   目标方法
             */
            public Object generate(Object target, Method method, Object... params){
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName()); //通过反射获取该类的类名(全称)
                sb.append(method.getName());  //通过反射获取方法名称
                for (Object obj : params){   //遍历后续的全部对象
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
}
