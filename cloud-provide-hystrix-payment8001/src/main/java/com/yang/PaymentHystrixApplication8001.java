package com.yang;

import javax.servlet.Servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixApplication8001 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentHystrixApplication8001.class, args);
	}
	
	 
	@Bean
	public ServletRegistrationBean<Servlet> getServlet(){
	    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
	    ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<Servlet>(streamServlet);
	    registrationBean.setLoadOnStartup(1);
	    registrationBean.addUrlMappings("/hystrix.stream");
	    registrationBean.setName("HystrixMetricsStreamServlet");
	    return registrationBean;
	}
}
