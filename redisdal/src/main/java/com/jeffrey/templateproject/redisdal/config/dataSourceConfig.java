package com.jeffrey.templateproject.redisdal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class dataSourceConfig {

    @Bean
    public RedisConnectionFactory redisCF() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("jeffreyxu.redis.rds.aliyuncs.com", 6379);
        redisStandaloneConfiguration.setPassword(RedisPassword.of("Jeffrey20130530Z"));
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

}
