package com.springtest1.demo.service;

public class SadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Bad Day";
    }
}
