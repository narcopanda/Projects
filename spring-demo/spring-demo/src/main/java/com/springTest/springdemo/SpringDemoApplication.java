package com.springTest.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.springTest.springdemo.average.Average;

//@SpringBootApplication
@ComponentScan
@Component
public class SpringDemoApplication {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringDemoApplication.class, args);
		Average avg = applicationContext.getBean(Average.class);
//		try(AnnotationConfigApplicationContext applicationContext = 
//				new AnnotationConfigApplicationContext(SpringDemoApplication.class)){
		
//			Average avg = applicationContext.getBean(Average.class);
			
		System.out.println(avg);
		
		float answer = avg.avg(new Student[] {new Student(3.4, "Sean"), new Student(4.0, "jon")});
		System.out.println(answer);
	}

//	}
}
