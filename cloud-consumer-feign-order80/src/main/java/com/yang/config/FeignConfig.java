package com.yang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignConfig {
	
	@Bean
	public Logger.Level logger() {
		return Logger.Level.FULL;
	}
}
