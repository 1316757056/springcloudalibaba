package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yang.entity.CommonResult;
import com.yang.entity.Payment;

@RestController
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String URL = "http://cloud-payment-service";
	
	@PostMapping("/consumer/payment/save")
	public CommonResult<?> save(Payment payment){
		return restTemplate.postForObject(URL+"/payment/save", payment, CommonResult.class);
	}
	
	@GetMapping("/consumer/payment/find/{id}")
	public CommonResult<?> find(@PathVariable("id") Integer id){
		return restTemplate.getForObject(URL+"/payment/find/"+id, CommonResult.class);
	}
}
