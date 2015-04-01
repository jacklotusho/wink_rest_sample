package com.lihong.javacalculator.api;

/**
 * This interface defines what methods a calculator has and what are the returns.
 * @author Lihong Yu
 * @version 1.0, September 2014
 */
public interface IJavaCalculator 
{
	public Integer getPlusResult(int inputA, int inputB);
	public Integer getMinusResult(int minusFromNum, int minusValue);
	public Integer getMultiplyResult(int inputA, int inputB);
	public Integer getQuotient(int dividend, int divisor);
}
