package com.in28minutes.spring.basics.springtest1.cdi;

import javax.inject.Named;

@Named
public class SomeCDIDAO {
	
	public int[] getData() {return new int[] {5,89,100};}

}
