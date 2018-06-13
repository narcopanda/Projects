package com.in28minutes.spring.basics.springtest1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.in28minutes.spring.basics.springtest1.properties.SomeExternalService;

@Configuration
@ComponentScan
//app.properties
@PropertySource("classpath:app.properties")
public class SpringPropertiesApplication {

	// What are the beans?
	// What are the dependencies of a bean?
	// Where to search for beans? => No need

	public static void main(String[] args) {

		// BinarySearchImpl binarySearch =
		// new BinarySearchImpl(new QuickSortAlgorithm());
		// Application Context
		try(AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringPropertiesApplication.class)){
		
		
			SomeExternalService service = 
				applicationContext.getBean(SomeExternalService.class);			

			System.out.println(service.returnServiceURL());
		
			
		}
//		((AbstractApplicationContext) applicationContext).close();
	}
}
