package com.oscar.akka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.AbstractActor;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MasterActor extends AbstractActor {

	private static final Logger logger = LoggerFactory.getLogger(MasterActor.class);

	
	@Autowired
    private GreetingService greetingService;

    public MasterActor(GreetingService greetingService) {
        this.greetingService = greetingService;
        
        
    }

	@Override
	public Receive createReceive() {
		
		return receiveBuilder().match(Greet.class, this::onGreet).build();
	}

	private void onGreet(Greet g){
		 String name = g.getName();
		 logger.info(greetingService.greet(name));
		 
	}
 

    public static class Greet {

        private String name;

        public Greet(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
    
 }    


