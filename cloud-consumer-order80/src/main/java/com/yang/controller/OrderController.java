package com.yang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String URL = "http://CLOUD-PAYMENT-SERVICE";
	
	@PostMapping("/consumer/payment/save")
	public CommonResult<?> save(Payment payment){
		return restTemplate.postForObject(URL+"/payment/save", payment, CommonResult.class);
	}
	
	@GetMapping("/consumer/payment/find/{id}")
	public CommonResult<?> find(@PathVariable("id") Integer id){
		return restTemplate.getForObject(URL+"/payment/find/"+id, CommonResult.class);
	}
	
	@GetMapping("/consumer/discover")
	public void discover() {
		List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
		System.err.println(instances.get(0).getHost());
		System.err.println(instances.get(0).getPort());
	}
}
