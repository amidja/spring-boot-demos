package org.amidja.home.demo.coffee.config;

import java.util.UUID;

import org.amidja.home.demo.coffee.model.Coffee;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;

@Component
public class CoffeeLoader {

	private final ReactiveRedisConnectionFactory factory;
	private final ReactiveRedisOperations<String, Coffee> coffeeOps;

	public CoffeeLoader(ReactiveRedisConnectionFactory factory, ReactiveRedisOperations<String, Coffee> coffeeOps) {
		this.factory = factory;
		this.coffeeOps = coffeeOps;
	}

	@PostConstruct
	public void loadData() {
		factory.getReactiveConnection().serverCommands().flushAll().thenMany(
				Flux.just("Jet Black Redis", "Darth Redis", "Black Alert Redis")
						.map(name -> new Coffee(UUID.randomUUID().toString(), name))
						.flatMap(coffee -> coffeeOps.opsForValue().set(Coffee.REDIS_KEY + coffee.getId(), coffee)))	
				.thenMany(coffeeOps.keys(Coffee.REDIS_KEY + "*")
						.flatMap(coffeeOps.opsForValue()::get))
				.subscribe(System.out::println);
	}
	
}