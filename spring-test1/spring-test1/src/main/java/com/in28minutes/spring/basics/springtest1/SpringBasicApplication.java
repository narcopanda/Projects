package com.in28minutes.spring.basics.springtest1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.spring.basics.springtest1.basic.BinarySearchImp;

@Configuration
@ComponentScan
public class SpringBasicApplication {

	// What are the beans?
	// What are the dependencies of a bean?
	// Where to search for beans? => No need

	public static void main(String[] args) {

		// BinarySearchImpl binarySearch =
		// new BinarySearchImpl(new QuickSortAlgorithm());
		// Application Context
		try(AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringBasicApplication.class)){
		
		
			BinarySearchImp binarySearch = 
				applicationContext.getBean(BinarySearchImp.class);

			BinarySearchImp binarySearch1 = 
				applicationContext.getBean(BinarySearchImp.class);

			System.out.println(binarySearch);
			System.out.println(binarySearch1);
		
			int result = 
				binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
			System.out.println(result);
		}
//		((AbstractApplicationContext) applicationContext).close();
	}
}
