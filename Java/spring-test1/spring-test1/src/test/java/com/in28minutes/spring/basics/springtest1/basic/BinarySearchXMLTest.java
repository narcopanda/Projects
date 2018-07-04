package com.in28minutes.spring.basics.springtest1.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.spring.basics.springtest1.SpringBasicApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
public class BinarySearchXMLTest {

	@Autowired
	BinarySearchImp binarySearch;
	
	@Test
	public void testBasic() {
		assertEquals(3, binarySearch.binarySearch(new int[] {}, 5));
		
	}

}
