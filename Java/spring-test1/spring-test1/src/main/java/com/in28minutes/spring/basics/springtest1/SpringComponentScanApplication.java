//package com.in28minutes.spring.basics.springtest1;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//import com.in28minutes.spring.basics.springtest1.scope.Person;
//
//
//
//@SpringBootApplication
//public class SpringComponentScanApplication {
//
//	private static Logger LOGGER = LoggerFactory.getLogger(SpringComponentScanApplication.class);
//	
//	
//	public static void main(String[] args) {
//		
//		ApplicationContext context = SpringApplication.run(SpringComponentScanApplication.class, args);
//		Person person = context.getBean(Person.class);
//		Person person1 = context.getBean(Person.class);
//
//		LOGGER.info("{}", person);
//		LOGGER.info("{}", person.getJdbcConnection());
//		
//		LOGGER.info("{}", person1);
//		LOGGER.info("{}", person1.getJdbcConnection());
//
//
//	}
//}
