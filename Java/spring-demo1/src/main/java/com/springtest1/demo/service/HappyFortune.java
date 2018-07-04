package com.springtest1.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Happy")
public class HappyFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "Lucky day";
    }
}
