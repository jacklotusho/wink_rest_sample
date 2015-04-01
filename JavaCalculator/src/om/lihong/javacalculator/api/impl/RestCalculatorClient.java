package om.lihong.javacalculator.api.impl;

import com.lihong.javacalculator.api.IJavaCalculator;
import com.lihong.javacalculator.services.ICalculatorService;
import com.lihong.javacalculator.services.RestCalculatorServiceImpl;

/**
 * This IJavaCalculator implementation defines calculator methods.
 * These methods use services to provide the returns
 * @author Lihong Yu
 * @version 1.0, September 2014
 */
public class RestCalculatorClient implements IJavaCalculator {
	
	private ICalculatorService calService = new RestCalculatorServiceImpl();

	@Override
	public Integer getPlusResult(int inputA, int inputB) {	
		try {
			return calService.plusService(inputA, inputB);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getMinusResult(int minusFromNum, int minusValue) {
		try {
			return calService.minusService(minusFromNum, minusValue);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getMultiplyResult(int inputA, int inputB) {
		try {
			return calService.multiplyService(inputA, inputB);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getQuotient(int dividend, int divisor) {
		try {
			return calService.divideService(dividend, divisor);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ICalculatorService getCalService() {
		return calService;
	}

	public void setCalService(ICalculatorService calService) {
		this.calService = calService;
	}	
}

