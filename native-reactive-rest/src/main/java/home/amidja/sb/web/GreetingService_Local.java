package home.amidja.sb.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class GreetingService_Local implements GreetingService{

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Override
	public Greeting getGreeting(String subject) {
		 return new Greeting(counter.incrementAndGet(), String.format(template, subject));		
	}

}
