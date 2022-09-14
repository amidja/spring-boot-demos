package org.amidja.home.demo.coffee.model;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

//@ExtendWith(SpringExtension.class)
@Slf4j
public class CoffeeLocalTest {

	@Test
	public void testCoffeeFlux() {
	
		Flux<Coffee> coffeeFlux = Flux.just("Arabica", "Robusta", "Black Robusta")
				.map(name -> new Coffee(UUID.randomUUID().toString(), name));

		coffeeFlux.subscribe(System.out::println);

	}

}
