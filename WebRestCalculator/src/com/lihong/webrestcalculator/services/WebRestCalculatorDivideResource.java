package com.lihong.webrestcalculator.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * This resource provide result of a dividend is divided by a divisor.
 * @author Lihong Yu
 * @version 1.0, September 2014
 */
@Path("/divide")
public class WebRestCalculatorDivideResource {
	
	/**
	 * getQuotient - get result of a dividend is divided by a divisor
	 * This class is an example of using QueryParam
	 * @param param1 - dividend
	 * @param param2 - divisor (cannot be 0)
	 * @return Response - response for request
	 */
	@GET
	@Path("/query")
	public Response getQuotient(
		@QueryParam("param1") int dividend,
		@QueryParam("param2") int divisor) {
		
		String msg;
		int result;
		
		if(divisor == 0) {
			msg = "divisor cannot be 0.";
		} else {	
			result = (int) dividend/divisor;	
			msg = "dividend : " + dividend + ", divisor : " + divisor
					+ " dividend divided by divisor = " + result;
		}

		return Response.status(200).entity(msg).build();
	} 
}