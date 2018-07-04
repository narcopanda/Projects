package com.databse.jpademo.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phonenumber")
    private int num;

    public Person() {
    }

    public Person(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Person(int id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
