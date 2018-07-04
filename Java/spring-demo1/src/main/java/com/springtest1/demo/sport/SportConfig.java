package com.springtest1.demo.sport;

import com.springtest1.demo.Coach.Coach;
import com.springtest1.demo.Coach.SwimCoach;
import com.springtest1.demo.service.FortuneService;
import com.springtest1.demo.service.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortune(){
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortune());
    }

}
