package com.lihong.javacalculator.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This ICalculatorService implementation defines REST services for a calculator.
 * These methods use REST services to provide the returns
 * {@inheritDoc} 
 * @author Lihong Yu
 * @version 1.0, September 2014
 */
public class RestCalculatorServiceImpl implements ICalculatorService {
	
	private static final String BASE_URI= "http://localhost:8080/WebRestCalculator/rest";
	
	private ClientConfig clientConfig;

	@Override
	public Integer plusService(int inputA, int inputB) throws Exception  {

		JSONObject inputObj= covertInputToJson(inputA, inputB);

		try {
			ClientConfig clientConfig = getClientConfig();
	    	RestClient restClient = new RestClient(clientConfig);
	    	
	    	Resource resource = restClient.resource(BASE_URI + "/plus");
	    	
	    	JSONObject response = resource.contentType(MediaType.APPLICATION_JSON)
		            .accept(MediaType.APPLICATION_JSON).post(JSONObject.class, inputObj);
			
	    	Integer r =  (Integer)response.get("result");
	    	
			if(r != null) {
				return r.intValue();		
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Exception in com.javacalculator.services.plusService ");	
			e.printStackTrace();
			throw e;
		}
	}

	private JSONObject covertInputToJson(int inputA, int inputB) {
		
		JSONObject inputObj = new JSONObject();
		
		try {
				inputObj.put("inputA", Integer.valueOf(inputA));
				inputObj.put("inputB", Integer.valueOf(inputB));
		} catch (JSONException e) {
			System.out.println("com.javacalculator.services.RestCalculatorServiceImpl.covertBeanToJson(). Exception: " 
										+ e.getMessage());
		}
			
		return inputObj;
	}

	@Override
	public Integer minusService(int minusFromNum, int minusValue) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			URL url = new URL(BASE_URI + "/minus/" + minusFromNum + "/" + minusValue);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			if ((output = br.readLine()) != null) {
				return Integer.parseInt(output);
			}	
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			br.close();
			conn.disconnect();
		}
		
		return null;
	}

	@Override
	public Integer multiplyService(int inputA, int inputB) throws Exception {
		JSONObject inputObj= covertInputToJson(inputA, inputB);

		try {
			ClientConfig clientConfig = getClientConfig();
	    	RestClient restClient = new RestClient(clientConfig);
	    	
	    	Resource resource = restClient.resource(BASE_URI + "/multiply");
	    	
	    	JSONObject response = resource.contentType(MediaType.APPLICATION_JSON)
		            .accept(MediaType.APPLICATION_JSON).post(JSONObject.class, inputObj);
			
	    	Integer r =  (Integer)response.get("result");
	    	
			if(r != null)
				return r.intValue();
			
			else
				return null;

		} catch (Exception e) {
			System.out.println("Exception in com.javacalculator.services.multiplyService ");	
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Integer divideService(int dividend, int divisor) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			URL url = composeURL(dividend, divisor);
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			String[] strArr = null;
			if ((output = br.readLine()) != null) {
				strArr = org.apache.wink.common.internal.utils.StringUtils.fastSplit(output, "=");
			}	
			
			if(strArr.length < 2) {
				return null;
			}
			
			if(!org.apache.commons.lang.StringUtils.isBlank(strArr[1])) {
				return Integer.parseInt(strArr[1].trim());
			}
				
			return null;			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
			conn.disconnect();
		}
		
		return null;
	}

	private URL composeURL(int dividend, int divisor) throws MalformedURLException {
		StringBuilder strBuilder = new StringBuilder(BASE_URI);
		strBuilder.append("/divide/query?param1=");
		strBuilder.append(dividend);
		strBuilder.append("&param2=");
		strBuilder.append(divisor);
		URL url = new URL(strBuilder.toString());
		return url;
	}
	
	public ClientConfig getClientConfig() {
		if(clientConfig == null)
		{
			RestWinkClientApplication clientApplication = new RestWinkClientApplication();
	    	Set<Object> s = new HashSet<Object>();
	    	s.add(new JacksonJaxbJsonProvider());
	    	clientApplication.setSingletons(s);
	    	clientConfig = new ClientConfig().applications(clientApplication);
		}
		return clientConfig;
	}

	

}
