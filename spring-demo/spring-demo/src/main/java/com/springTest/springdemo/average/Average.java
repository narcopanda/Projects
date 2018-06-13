package com.springTest.springdemo.average;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springTest.springdemo.Student;

@Service
public class Average{

	@Autowired	
	Student student;
	
	public float avg(Student[] temp) {
		float total = 0;
		float counter = 0;
		for(Student std : temp) {
			total += std.getGpa();
			counter++;
		}
		return total / counter;
	}
	
	
	
}
