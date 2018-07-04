package com.springtest1.demo;

import com.springtest1.demo.Coach.Coach;
import com.springtest1.demo.Coach.SwimCoach;
import com.springtest1.demo.sport.SportConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
//@ComponentScan
public class swimJavaConfigDemoApp {

    private static Logger log = LoggerFactory.getLogger(swimJavaConfigDemoApp.class);


    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(SportConfig.class);
//        ApplicationContext applicationContext = SpringApplication.run(JavaConfigDemoApp.class, args);

//        Coach coach = applicationContext.getBean(TennisCoach.class);
        SwimCoach coach = configApplicationContext.getBean("swimCoach", SwimCoach.class);
        log.info("the bean used is -> {}", coach);
        log.info("The workout for today is {}", coach.getDailyWorkout());
        log.info("the fortune is {}", coach.getDailyFortune());

        log.info("email: {}", coach.getEmail());
        log.info("Team: {}", coach.getTeam());
    }

}
