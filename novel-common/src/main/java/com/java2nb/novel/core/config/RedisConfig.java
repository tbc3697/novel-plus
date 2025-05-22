package com.java2nb.novel.core.config;

import groovy.util.logging.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

@lombok.extern.slf4j.Slf4j
@Configuration
@Slf4j
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        var redisTemplate = new RedisTemplate<Object, Object>();
        setRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        var redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new LoggingStringRedisSerializer());
        redisTemplate.setValueSerializer(new LoggingStringRedisSerializer());
        redisTemplate.setHashKeySerializer(new LoggingStringRedisSerializer());
        redisTemplate.setHashValueSerializer(new LoggingStringRedisSerializer());
        return redisTemplate;
    }

    private void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate, RedisConnectionFactory redisConnectionFactory) {
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new LoggingStringRedisSerializer());
        // redisTemplate.setValueSerializer(new LoggingStringRedisSerializer());
        redisTemplate.setHashKeySerializer(new LoggingStringRedisSerializer());
        // redisTemplate.setHashValueSerializer(new LoggingStringRedisSerializer());
    }


    class LoggingStringRedisSerializer extends StringRedisSerializer {
        @Override
        public byte[] serialize(@Nullable String t) {

            return super.serialize(t);
        }

        @Override
        public String deserialize(@Nullable byte[] bytes) {

            return super.deserialize(bytes);
        }
    }


}
