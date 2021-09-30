package org.amidja.home.demo.coffee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
	
	public final static String REDIS_KEY = "demo:coffees:id:";
	
	private String id;
	private String name;
	
}
