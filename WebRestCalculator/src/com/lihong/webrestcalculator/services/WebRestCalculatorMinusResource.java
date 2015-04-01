package com.lihong.webrestcalculator.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
/**
 * This resource provide result of one number minus another number.
 * @author Lihong Yu
 * @version 1.0, September 2014
 */
@Path("/minus")
public class WebRestCalculatorMinusResource {
 
	/**
	 * getMinusResult - get result of one number minus another number
	 * This class is an example of using PathParam
	 * @param param1 - one input number
	 * @param param2 - another input number
	 * @return Integer - minus result
	 */
	@GET
	@Produces("application/json")
	@Path("/{param1}/{param2}")
	public Integer getMinusResult(@PathParam("param1") int param1, @PathParam("param2") int param2) {
 
		Integer result = new Integer(param1 - param2);		
		return result; 
 
	}
 
}