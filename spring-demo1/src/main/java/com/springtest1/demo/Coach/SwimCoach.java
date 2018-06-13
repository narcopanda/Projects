package com.springtest1.demo.Coach;

import com.springtest1.demo.service.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService service;

    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService service){
        this.service = service;
    }
    @Override
    public String getDailyWorkout() {
        return "swim 1000m";
    }

    @Override
    public String getDailyFortune() {
        return service.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
