package com.SpringBoot.loncotoBack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class JsonConfiguration {
	@Autowired(required = true)
	public void configJackson(ObjectMapper om) {
		om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
	
	@Bean
	public SpelAwareProxyProjectionFactory projectionFactory() {
		return new SpelAwareProxyProjectionFactory();
	}
}
