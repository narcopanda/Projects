package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationsTest {

	@Mock
	DataService dataSeriveMock;
	
	@InjectMocks
	SomeBusinessImp businessImp;
	
	@Test
	public void tFindTheGreatestFromAllData() {
		
		when(dataSeriveMock.retriveAllData()).thenReturn(new int[] {24, 15, 3});
		assertEquals(24, businessImp.findTheGreatestFromAllData());
	}
	
	@Test
	public void tFindTheGreatestFromAllData_ForOneValue() {
		
		when(dataSeriveMock.retriveAllData()).thenReturn(new int[] {15});
		assertEquals(15, businessImp.findTheGreatestFromAllData());
		
	}

	@Test
	public void tFindTheGreatestFromAllData_NoValues() {
		
		when(dataSeriveMock.retriveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImp.findTheGreatestFromAllData());
		
	}
}

