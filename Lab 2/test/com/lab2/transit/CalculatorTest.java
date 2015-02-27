package com.lab2.transit;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;

@RunWith(Parameterized.class)
 public class CalculatorTest {

	private static final double DELTA = 1e-15;
	private double expected;
	private int age;
	private String time;
	private boolean isHoliday;
	private FareCalculator calculator;
	
	public CalculatorTest(double expected, int age, String time, boolean isHoliday)
	{
		this.expected=expected;
		this.age=age;
		this.time=time;
		this.isHoliday=isHoliday;
	}
	
	@Parameters
	public static Collection<Object[]> testParams() {
		return Arrays.asList(new Object[][]{
				{ 0.0,4,"6:00",false}, {0.0,4,"6:59",false}, {2.5,4,"7:00",false},{2.5,4,"7:01",false},{2.5,4,"8:59",false},{2.5,4,"9:00",false},{0.0,4,"9:01",false},{0.0,5,"6:00",false},{2.5,6,"6:00",false},{2.5,64,"6:00",false},{0.0,65,"6:00",false},{0.0,68,"6:00",false}, {0.0,4,"7:30",true},{2.5,4,"7:30",false} 
		});
		
	}
	
	public void setUp(){
		calculator=new FareCalculator();
	}
	@Test
	public void calcuateFareTest(){
		assertEquals(expected,FareCalculator.calculateFare(age,time,isHoliday),DELTA);
	}
	
	}
	
	
  






