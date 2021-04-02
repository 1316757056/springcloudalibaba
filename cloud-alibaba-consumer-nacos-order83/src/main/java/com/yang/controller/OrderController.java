package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	
	private static final String URI = "http://cloud-payment-nacos-service";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/consumer/find/{id}")
	public String find(@PathVariable("id") int id) {
		return  restTemplate.getForObject(URI+"/find/"+id, String.class);
	}
}
