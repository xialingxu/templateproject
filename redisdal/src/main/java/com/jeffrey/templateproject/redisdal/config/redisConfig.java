package com.jeffrey.templateproject.redisdal.config;


import com.jeffrey.templateproject.redisdal.entity.Product;
import com.jeffrey.templateproject.redisdal.redisbiz.RedisActions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@Import({ dataSourceConfig.class})
public class redisConfig {


    @Bean
    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory redisCF) {
        RedisTemplate<String, Product> redis = new RedisTemplate<String, Product>();
        redis.setConnectionFactory(redisCF);
        return redis;
    }

    @Bean
    public RedisActions redisActions()
    {
        return new RedisActions();
    }
}
