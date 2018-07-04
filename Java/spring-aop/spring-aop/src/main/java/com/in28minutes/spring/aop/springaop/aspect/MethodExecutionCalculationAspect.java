package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	
	@Around("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {		
//		startTime = x
		long startTime = System.currentTimeMillis();
//		allow execution of method
		joinPoint.proceed();
//		end Time = y
		long timeTaken = System.currentTimeMillis() - startTime;
		
		log.info("Time Taken by {} is {}", joinPoint, timeTaken);
	}
	
	
}
