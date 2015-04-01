package com.lihong.webrestcalculator.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;


/**
 * This resource provide result of a number plus another number.
 * @author Lihong Yu
 * @version 1.0, September 2014
 */
@Path("/plus")
public class WebRestCalculatorPlusResource {

	/**
	 * getMultiply - get result of one number plus another number
	 * This class is an example of putting inputs in a JSON object
	 * @param inputJson - input JSON object
	 * @return JSONObject - output JSON object
	 */
	@POST
	@Consumes( { MediaType.APPLICATION_JSON })
    @Produces( { MediaType.APPLICATION_JSON })
    public JSONObject getPlus(JSONObject inputJson)
    {
		JSONObject rObj = new JSONObject();
		if(inputJson == null)
		{
			System.out.println("Input JASON Object is null.");
			try {
				rObj.put("result", "-1");
			} catch (JSONException e) {
				System.out.println("Exceltion in getPlus when try to put -1 in return JASON Object.");
				e.printStackTrace();
			}
			return rObj;
		}
		
		try {
			int inputA = inputJson.getInt("inputA");
		    int inputB = inputJson.getInt("inputB");
		    int r = inputA + inputB;
			rObj.put("result", Integer.valueOf(r));
			return rObj;
		} catch (JSONException e2) {
			System.out.println("Exceltion in getPlus when try to put plus result in JASON Object.");
			e2.printStackTrace();
			return null;
		}
    }

}
