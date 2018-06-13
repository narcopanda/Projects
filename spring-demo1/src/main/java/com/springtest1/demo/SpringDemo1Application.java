package com.springtest1.demo;

import com.springtest1.demo.Coach.Coach;
import com.springtest1.demo.Coach.TennisCoach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@ComponentScan
public class SpringDemo1Application {

    private static Logger log = LoggerFactory.getLogger(SpringDemo1Application.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringDemo1Application.class, args);

//        Coach coach = applicationContext.getBean(TennisCoach.class);
        Coach coach = applicationContext.getBean("tennisCoach", Coach.class);
        log.info("the bean used is -> {}", coach);
        log.info("The workout for today is {}", coach.getDailyWorkout());
        log.info("the fortune is {}", coach.getDailyFortune());
    }


}
