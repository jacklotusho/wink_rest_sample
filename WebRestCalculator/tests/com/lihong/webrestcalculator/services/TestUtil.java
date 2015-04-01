package com.lihong.webrestcalculator.services;

import java.util.HashSet;
import java.util.Set;

import org.apache.wink.client.ClientConfig;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

public class TestUtil {
	public static ClientConfig createClientConfig() {
		WebRestCalculatorApplication clientApplication = new WebRestCalculatorApplication();
		Set<Object> s = new HashSet<Object>();
    	s.add(new JacksonJaxbJsonProvider());
    	clientApplication.setSingletons(s);
    	ClientConfig clientConfig = new ClientConfig().applications(clientApplication);
		return clientConfig;
	}
}
