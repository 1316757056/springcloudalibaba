package com.yang.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yang.api.fallback.PaymentFallback;

@FeignClient(name = "cloud-payment-nacos-service",fallback = PaymentFallback.class)
public interface PaymentApi {
	
	@GetMapping("/find/{id}")
	public String find(@PathVariable("id") int id);
	
}
