package com.lihong.javacalculator.api;

import static org.junit.Assert.assertEquals;
import om.lihong.javacalculator.api.impl.RestCalculatorClient;

import org.junit.Test;


public class RestCalculatorClientTest {

	@Test
	public void testMyRestCalculator() {
		
		IJavaCalculator cal = new RestCalculatorClient();
		int plusResult = cal.getPlusResult(1, 2);
		assertEquals(3, plusResult);
		
		int minusResult = cal.getMinusResult(3, 1);
		assertEquals(2, minusResult); 
		
		int multiplyResult = cal.getMultiplyResult(3, 2);
		assertEquals(6, multiplyResult);
		
		int divideResult = cal.getQuotient(6, 2);
		assertEquals(3, divideResult);
	}

}
