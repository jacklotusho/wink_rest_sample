package com.lihong.webrestcalculator.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

public class WebRestCalculatorApplication extends Application
{
	private Set<Object> s = Collections.emptySet();

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(WebRestCalculatorPlusResource.class);
		classes.add(WebRestCalculatorMinusResource.class);
		classes.add(WebRestCalculatorMultiplyResource.class);
		classes.add(WebRestCalculatorDivideResource.class);
		
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		this.s = new HashSet<Object>();
		
		ObjectMapper mapper = new ObjectMapper();
		AnnotationIntrospector primary = new JaxbAnnotationIntrospector();
		AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
		AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary,
				secondary);
		mapper.getDeserializationConfig().setAnnotationIntrospector(pair);
		mapper.getSerializationConfig().setAnnotationIntrospector(pair);

		JacksonJaxbJsonProvider jaxbProvider = new JacksonJaxbJsonProvider();
		jaxbProvider.setMapper(mapper);

		s.add(jaxbProvider);
		return s;
	}

	public void setSingletons(final Set<Object> singletons) {
		this.s = singletons;
	}

}
