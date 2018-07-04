package com.in28minutes.spring.basics.springtest2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringTest2Application {

	private static Logger logger = LoggerFactory.getLogger(SpringTest2Application.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringTest2Application.class, args);
		
		for(String name : applicationContext.getBeanDefinitionNames()) {
//			System.out.println(name);
			logger.info("{  }",name);
		}
	}
}
