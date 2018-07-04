package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SomeBusinessMockTest {

	@Test
	public void tFindTheGreatestFromAllData() {
		
		DataService dataSeriveMock = mock(DataService.class);		
		when(dataSeriveMock.retriveAllData()).thenReturn(new int[] {24, 15, 3});
		
		SomeBusinessImp businessImp = new SomeBusinessImp(dataSeriveMock);
		int result = businessImp.findTheGreatestFromAllData();
		assertEquals(24, result);
	}
	
	@Test
	public void tFindTheGreatestFromAllData_ForOneValue() {
		
		DataService dataSeriveMock = mock(DataService.class);		
		when(dataSeriveMock.retriveAllData()).thenReturn(new int[] {15});
		
		SomeBusinessImp businessImp = new SomeBusinessImp(dataSeriveMock);
		int result = businessImp.findTheGreatestFromAllData();
		assertEquals(15, result);
	}

}

