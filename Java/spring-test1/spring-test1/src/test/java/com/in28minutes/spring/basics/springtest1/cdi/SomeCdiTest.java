package com.in28minutes.spring.basics.springtest1.cdi;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

//@RunWith(MockitoJUnitRunner.class)
public class SomeCdiTest {
	
//	use this instead of using RunWith
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	

	@InjectMocks
	SomeCDI business;
	
	@Mock
	SomeCDIDAO daoMock;
		
	@Test
	public void testBasic() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] {2,4});
		assertEquals(4, business.findGreatest());
		
	}
	
//	empty
	@Test
	public void testBasic2() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { });
		assertEquals(Integer.MIN_VALUE, business.findGreatest());
	}
	
//	equal
	@Test
	public void testBasic3() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] {2,2 });
		assertEquals(2, business.findGreatest());
	}

}
