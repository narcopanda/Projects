package com.springTest.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private double gpa;
	private String name;
	
	public Student() {
		
	}
	public Student(double gpa, String name) {
		super();
		this.gpa = gpa;
		this.name = name;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [gpa=" + gpa + ", name=" + name + "]";
	}
	
	

}
