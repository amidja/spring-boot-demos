package org.amidja.home.demo.coffee.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.test.context.ActiveProfiles;
import org.amidja.home.demo.coffee.config.*;

@SpringBootTest(classes = RedisServerConfiguration.class)
@ActiveProfiles("local")
class CoffeeIntegrationTest {

	@Autowired
	private  ReactiveRedisOperations<String, Coffee> coffeeOps;
	
	@Test
	void testPlumbing() {
		assertNotNull(coffeeOps);
		coffeeOps.keys("*");
	}

}