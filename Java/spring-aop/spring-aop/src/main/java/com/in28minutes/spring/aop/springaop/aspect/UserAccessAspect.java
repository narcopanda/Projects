package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class UserAccessAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	
	//	what kind of method calls I would intercept
	@Before("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
	public void before(JoinPoint joinPoint) {
		log.info(" Check for user access");
		log.info(" Allowed execution for {}", joinPoint);
	}
}
