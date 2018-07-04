//package com.in28minutes.spring.basics.springtest1;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import com.in28minutes.spring.basics.springtest1.cdi.SomeCDI;
////import com.in28minutes.spring.basics.springtest1.cdi.SomeCDIDAO;;
//
//
//
////@SpringBootApplication
//@Configuration
//@ComponentScan
//public class SpringCDIApplication {
//
//	private static Logger LOGGER = LoggerFactory.getLogger(SpringCDIApplication.class);
//	
//	
//	public static void main(String[] args) {
//		
//		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
//				SpringCDIApplication.class)) {
//		SomeCDI cdi = applicationContext.getBean(SomeCDI.class);
//
//		LOGGER.info("{} dao-{}", cdi, cdi.getSomeCDIDAO());
//		
//		}
//
//	}
//}
