package com.mysqlDatabasetest.mysqlJPAdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysqlDatabasetest.mysqlJPAdemo.data.Person;
import com.mysqlDatabasetest.mysqlJPAdemo.jpa.PersonDataRepo;

@SpringBootApplication
public class MysqlJpaDemoApplication implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	PersonDataRepo person;
	public static void main(String[] args) {
		SpringApplication.run(MysqlJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		log.info("insetering new person -> {}", person.save(new Person("Pat", 12345)));
		log.info("All the people in the book -> {}", person.findAll());
	}
}
