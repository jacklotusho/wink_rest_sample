package com.lihong.javacalculator.app;

import com.lihong.javacalculator.api.IJavaCalculator;
import com.lihong.javacalculator.api.RestCalculatorClient;

public class CalculatorApp {

	public static void main(String[] args) {
		IJavaCalculator cal = new RestCalculatorClient();
		
		System.out.println("************** Lihong Yu's REST Calaulator Code Sample **************");
		
		Integer plusResult = cal.getPlusResult(1, 2);
		System.out.println("*** Number1 = 1 Number2 = 2 Number1 + Number2 = " + plusResult +" ****");
		
		Integer minusResult = cal.getMinusResult(5, 3);
		System.out.println("*** Number1 = 5 Number2 = 3 Number1 - Number2 = " + minusResult +" ****");
		System.out.println("*** You can try this with a browser: http://localhost:8080/WebRestCalculator/rest/minus/5/3");
		
		Integer multiplyResult = cal.getMultiplyResult(3, 2);
		System.out.println("*** Number1 = 3 Number2 = 2 Number1 * Number2 = " + multiplyResult +" ****");
		
		Integer divideResult = cal.getQuotient(6, 2);
		if(divideResult == null) {
			System.out.println("*** Invalida Input. Divisor cannot be 0 and has to be a number");
		}
			
		System.out.println("*** Number1 = 6 Number2 = 2 Number1 / Number2 = " + divideResult +" ****");
		System.out.println("*** You can try this with a browser: http://localhost:8080/WebRestCalculator/rest/divide/query?param1=6&param2=2");
	}

}
