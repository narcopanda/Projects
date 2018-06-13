package com.mysqlDatabasetest.mysqlJPAdemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysqlDatabasetest.mysqlJPAdemo.data.Person;

public interface PersonDataRepo extends JpaRepository<Person, Integer>{

}
