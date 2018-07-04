package com.springtest1.demo.Coach;

import com.springtest1.demo.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{

    @Autowired
//    @Qualifier("Happy")
    @Qualifier("Rand")
    private FortuneService service;

//    public TennisCoach(){
//        System.out.println("default constructor");
//    }

//   @Autowired
    public void setService(FortuneService service) {
        System.out.println("setter injection");
        this.service = service;
    }

//    @Autowired
//    public TennisCoach(FortuneService service) {
//        this.service = service;
//    }

    @Override
    public String getDailyWorkout() {
        return "practice backhand";
    }

    @Override
    public String getDailyFortune() {
        return service.getFortune();
    }

    @PostConstruct
    public void startUp(){
        System.out.println("after construct");
    }
    @PreDestroy
    public void cleanUp(){
        System.out.println("its dead");
    }
}
