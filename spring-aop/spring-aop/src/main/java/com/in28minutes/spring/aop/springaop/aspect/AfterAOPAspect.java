package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class AfterAOPAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	
	//	what kind of method calls I would intercept
	@AfterReturning(value = "com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.BusinessLayerExecution()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
//		log.info(" Check for user access");
//		log.info(" Allowed execution for", joinPoint);
		
		log.info("{} returned with value {}", joinPoint, result);
	}
	
	@AfterThrowing(value = "com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.BusinessLayerExecution()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		
		log.info("{} returned with value {}", joinPoint, exception);
	}
	
	@After(value = "com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.BusinessLayerExecution()")
	public void after(JoinPoint joinPoint) {
		
		log.info("after execution of {}", joinPoint);
	}
}
