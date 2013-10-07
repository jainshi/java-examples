package test.spring.service.impl;

import test.spring.service.GreetingService;

public class HelloGreetingServiceImpl implements GreetingService {

	public String sayGreeting(final String name) {
		
		return "Hello " + name + " !!!";
	}

}
