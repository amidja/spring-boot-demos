package home.amidja.sb.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!local")
@Service
public class GreetingService_German implements GreetingService{

	private static final String template = "Guten Tag, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Override
	public Greeting getGreeting(String subject) {
		 return new Greeting(counter.incrementAndGet(), String.format(template, subject));		
	}
}
