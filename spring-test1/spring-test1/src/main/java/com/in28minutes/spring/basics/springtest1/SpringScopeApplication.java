//package com.in28minutes.spring.basics.springtest1;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import com.in28minutes.spring.basics.springtest1.scope.Person;
//
//
//
//@Configuration
//@ComponentScan
//public class SpringScopeApplication {
//
//	private static Logger LOGGER = LoggerFactory.getLogger(SpringComponentScanApplication.class);
//	
//	
//	public static void main(String[] args) {
//		
//		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
//				SpringScopeApplication.class)) {
//
//			Person personDao = applicationContext.getBean(Person.class);
//
//			Person personDao2 = applicationContext.getBean(Person.class);
//
//			LOGGER.info("{}", personDao);
//			LOGGER.info("{}", personDao.getJdbcConnection());
//			LOGGER.info("{}", personDao.getJdbcConnection());
//
//			LOGGER.info("{}", personDao2);
//			LOGGER.info("{}", personDao.getJdbcConnection());
//		}
//
//	}
//}
//
