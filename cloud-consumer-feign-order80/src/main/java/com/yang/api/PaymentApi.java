package com.yang.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yang.entity.CommonResult;
import com.yang.entity.Payment;

@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PaymentApi {
	
	@GetMapping("/payment/find/{id}")
	public CommonResult<Payment> find(@PathVariable("id") Integer id);
	
	@PostMapping("/payment/save")
	public CommonResult<String> save(@RequestBody Payment payment);
	
	@GetMapping("/payment/timeout")
	public CommonResult<Payment> timeout();
}
