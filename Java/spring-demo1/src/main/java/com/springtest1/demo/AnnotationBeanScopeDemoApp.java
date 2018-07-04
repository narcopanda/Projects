package com.springtest1.demo;

import com.springtest1.demo.Coach.Coach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AnnotationBeanScopeDemoApp {

    private static Logger log = LoggerFactory.getLogger(AnnotationBeanScopeDemoApp.class);


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AnnotationBeanScopeDemoApp.class, args);

//        Coach coach = applicationContext.getBean(TennisCoach.class);
        Coach coach = applicationContext.getBean("tennisCoach", Coach.class);
        Coach coach2 = applicationContext.getBean("tennisCoach", Coach.class);
        log.info("the bean used is -> {}", coach);
        log.info("the bean used is -> {}", coach2);
        log.info("The workout for today is {}", coach.getDailyWorkout());
        log.info("the fortune is {}", coach.getDailyFortune());
    }

}
