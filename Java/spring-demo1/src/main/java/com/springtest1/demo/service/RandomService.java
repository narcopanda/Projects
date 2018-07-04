package com.springtest1.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Qualifier("Rand")
public class RandomService implements FortuneService {

    private String[] data = {"Bad day", "Good day", "Ok day"};


    private Random rand = new Random();

    @Override
    public String getFortune() {
        int index = rand.nextInt(data.length);
        String temp = data[index];
        return temp;
    }
}
