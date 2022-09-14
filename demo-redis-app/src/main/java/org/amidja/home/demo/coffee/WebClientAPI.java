package org.amidja.home.demo.coffee;

import org.amidja.home.demo.coffee.model.Coffee;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class WebClientAPI {

	private WebClient webClient;

	public WebClientAPI() {
		webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
	}

	public static void main(String args[]) {
		WebClientAPI api = new WebClientAPI();
		api.getCoffees()
		.subscribeOn(Schedulers.newSingle("myThread"))
		.subscribe(System.out::println);
	}

	Flux<Coffee> getCoffees() {
		return webClient.get().uri("/coffees")
				.retrieve().bodyToFlux(Coffee.class)
				.doOnNext(o -> System.out.println("**********GET: " + o));
	}

}
