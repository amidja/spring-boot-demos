package org.amidja.home.demo.coffee.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;
import java.util.ArrayList;
import java.util.UUID;

import org.amidja.home.demo.coffee.config.TestRedisServerConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.test.context.ActiveProfiles;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

// integration will use embedded-redis
@SpringBootTest(classes = TestRedisServerConfiguration.class)
//@ActiveProfiles("integration")
@ActiveProfiles("local")
class CoffeeLocalIntegrationTest {

	@Autowired
	private  ReactiveRedisOperations<String, Coffee> coffeeOps;
	

	@Test
	void testPlumbing() {
		assertNotNull(coffeeOps);
		
		StepVerifier.create(coffeeOps.keys(Coffee.REDIS_KEY + "*"))
			.recordWith(ArrayList::new).thenConsumeWhile(x-> true)
			 .expectRecordedMatches(elements -> !elements.isEmpty())
		        .verifyComplete();;
		
	}
	
	@Test
	void testSwitchToNewValue() {

		final String uuid = UUID.randomUUID().toString();
		Coffee coffeeValue = new Coffee(uuid, "Arabica Redis");

		// Save Value:
		Mono<Boolean> result = coffeeOps.opsForValue().set(coffeeValue.getId(), coffeeValue);
		StepVerifier.create(result).expectNext(true).verifyComplete();
		
		// Retrieve Value:
		Mono<Coffee> fetchedCoffee = coffeeOps.opsForValue().get(coffeeValue.getId());
		StepVerifier.create(fetchedCoffee).expectNext(new Coffee(uuid, "Arabica Redis")).verifyComplete();

		//Switch to the new value, when key not found in REDIS
		Mono<Coffee> deferCoffee = Mono.defer(() -> Mono.just(new Coffee(uuid, "Arabica")));

		fetchedCoffee = coffeeOps.opsForValue().get("not a key value").switchIfEmpty(deferCoffee);

		StepVerifier.create(fetchedCoffee).expectNext(new Coffee(uuid, "Arabica")).verifyComplete();

	}
	
	
	@Test
	void testPopulateRedisWhenValueNotFound() {

		final String uuid = UUID.randomUUID().toString();

		Coffee coffee = new Coffee(uuid, "Arabica");

		StepVerifier.create(coffeeOps.opsForValue().get(uuid)
				.switchIfEmpty(Mono.defer(() -> setCoffee(coffee))))
				.expectNext(new Coffee(uuid, "Arabica")).verifyComplete();

	}

	//Save coffee to redis
	private Mono<Coffee> setCoffee(Coffee coffee) {
		return coffeeOps.opsForValue().set(Coffee.REDIS_KEY + coffee.getId(), coffee, Duration.ofMinutes(5))
				.flatMap(set -> {
					return Mono.just(coffee);
				});
	}
}