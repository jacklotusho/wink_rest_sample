package com.lihong.javacalculator.services;

/**
 * This interface defines services APIs.
 * @author Lihong Yu
 * @version 1.0, September 2014
 */
public interface ICalculatorService {
	public Integer plusService(int inputA, int inputB)throws Exception;
	public Integer minusService(int minusFromNum, int minusValue)throws Exception;
	public Integer multiplyService(int inputA, int inputB)throws Exception;
	public Integer divideService(int dividend, int divisor)throws Exception;
}
