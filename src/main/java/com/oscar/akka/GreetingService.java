package com.oscar.akka;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class GreetingService {

	private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);
	
    public String greet(String name) {
    	
    	try {
    		int randomNum = ThreadLocalRandom.current().nextInt(1, 6);
    		logger.info("randomNum: {}", randomNum);
    		
			TimeUnit.SECONDS.sleep(randomNum);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    	
        return "Hello, " + name;
    }

}