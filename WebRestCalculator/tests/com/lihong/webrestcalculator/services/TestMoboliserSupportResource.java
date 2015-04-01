package com.lihong.webrestcalculator.services;

import javax.ws.rs.core.MediaType;

import junit.framework.TestCase;

import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class TestMoboliserSupportResource extends TestCase {

	private static final String BASE_URI= "http://localhost:8080/WebRestCalculator/rest";

	@Test
	public void testWebRestCalculatorPlus() {
		ClientConfig clientConfig = TestUtil.createClientConfig();
		RestClient restClient = new RestClient(clientConfig);

		Resource resource = restClient.resource(BASE_URI + "/plus");
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("inputA", Integer.valueOf("1"));
			jsonObj.put("inputB", Integer.valueOf("2"));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		JSONObject response = resource.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(JSONObject.class, jsonObj);
		assertNotNull(response);
		try {
			assertEquals(3, response.get("result"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testWebRestCalculatorMinus() {
		HttpURLConnection conn = null;
		try {

			URL url = new URL(BASE_URI + "/minus/3/2");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}		

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			conn.disconnect();
		}
		
	}

	@Test
	public void testWebRestCalculatorMultiply() {
		ClientConfig clientConfig = TestUtil.createClientConfig();
		RestClient restClient = new RestClient(clientConfig);

		Resource resource = restClient.resource(BASE_URI + "/multiply");
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("inputA", Integer.valueOf("3"));
			jsonObj.put("inputB", Integer.valueOf("8"));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		JSONObject response = resource.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(JSONObject.class, jsonObj);
		assertNotNull(response);
		try {
			assertEquals(24, response.get("result"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testWebRestCalculatorDivide() {
		HttpURLConnection conn = null;
		try {

			URL url = new URL(BASE_URI + "/divide/query?param1=100&param2=20");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		
	}

}
