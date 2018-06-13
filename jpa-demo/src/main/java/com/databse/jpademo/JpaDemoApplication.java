package com.databse.jpademo;

import com.databse.jpademo.entity.Person;
import com.databse.jpademo.entity.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {


    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static Logger log1 = LoggerFactory.getLogger(JpaDemoApplication.class);

    @Autowired
    PersonRepo repository;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(JpaDemoApplication.class, args);
        PersonRepo person = applicationContext.getBean(PersonRepo.class);
        log1.info("The bean is -> {}", person);
    }

    @Override
    public void run(String... args) {
        log.info("Adding a new person -> {}", repository.save(new Person(3, "jack", 555555)));
        log.info("the whole book ->{}", repository.findAll());
    }
}
