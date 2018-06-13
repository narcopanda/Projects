//package com.in28minutes.spring.basics.springtest1;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.in28minutes.spring.basics.springtest1.xml.XMLPerson;
//
//@Configuration
//@ComponentScan
//public class SpringXMLContextApplication {
//
//	// What are the beans?
//	// What are the dependencies of a bean?
//	// Where to search for beans? => No need
//
//	private static Logger LOGGER = LoggerFactory.getLogger(SpringScopeApplication.class);
//	
//	public static void main(String[] args) {
//
//		// BinarySearchImpl binarySearch =
//		// new BinarySearchImpl(new QuickSortAlgorithm());
//		// Application Context
//		try(ClassPathXmlApplicationContext applicationContext = 
//				new ClassPathXmlApplicationContext("applicationContext.xml")){
//		
//			LOGGER.info("Beans Loaded -> {}", (Object)applicationContext.getBeanDefinitionNames());
//			
//			applicationContext.getBeanDefinitionNames();
//			XMLPerson person = applicationContext.getBean(XMLPerson.class);
//			
//			LOGGER.info("{} {}", person, person.getXMLJdbcConnection());
//
//
//			
//			
//		}
////		((AbstractApplicationContext) applicationContext).close();
//	}
//}
