package org.amidja.home.demo.coffee.config;

import org.amidja.home.demo.coffee.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CoffeeConfiguration {

	@Autowired
	private ReactiveStringRedisTemplate redisTemplate;
	
	@Bean
	ReactiveRedisOperations<String, Coffee> redisOperations(ReactiveRedisConnectionFactory factory) {
		
		StringRedisSerializer keySerializer = new StringRedisSerializer();
		Jackson2JsonRedisSerializer<Coffee> valueSerializer = new Jackson2JsonRedisSerializer<>(Coffee.class);
		
		RedisSerializationContext.RedisSerializationContextBuilder<String, Coffee> builder =
				RedisSerializationContext.newSerializationContext(keySerializer);

		RedisSerializationContext<String, Coffee> context = builder.value(valueSerializer).build();

		return new ReactiveRedisTemplate<>(factory, context);
	}
	
}
