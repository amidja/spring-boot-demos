package org.amidja.home.demo.coffee;


//org.amidja.home.demo.coffee.ReactiveRedisApplication
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveRedisApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveRedisApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		log.info("in application runner calling: curl http://localhost:8080/coffees ");
	}
}
