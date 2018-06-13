package com.springtest1.demo;

import com.springtest1.demo.Coach.Coach;
import com.springtest1.demo.sport.SportConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@ComponentScan
public class JavaConfigDemoApp {

    private static Logger log = LoggerFactory.getLogger(JavaConfigDemoApp.class);


    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(SportConfig.class);
//        ApplicationContext applicationContext = SpringApplication.run(JavaConfigDemoApp.class, args);

//        Coach coach = applicationContext.getBean(TennisCoach.class);
        Coach coach = configApplicationContext.getBean("tennisCoach", Coach.class);
        Coach coach2 = configApplicationContext.getBean("tennisCoach", Coach.class);
        log.info("the bean used is -> {}", coach);
        log.info("the bean used is -> {}", coach2);
        log.info("The workout for today is {}", coach.getDailyWorkout());
        log.info("the fortune is {}", coach.getDailyFortune());
    }

}
