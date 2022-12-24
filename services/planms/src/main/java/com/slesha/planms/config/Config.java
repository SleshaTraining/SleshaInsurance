package com.slesha.planms.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
@EnableJpaRepositories(basePackages = "com.slesha.planms.repo")
@EnableCaching
public class Config {

@Bean
public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    RedisSerializationContext.SerializationPair<Object> jsonSerializer = RedisSerializationContext.SerializationPair
            .fromSerializer(new GenericJackson2JsonRedisSerializer());
    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
            .serializeValuesWith(jsonSerializer).disableCachingNullValues().entryTtl(Duration.ofSeconds(30));
    RedisCacheManager manager=RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory)
    .cacheDefaults(config).build();
    return manager;

}
}
