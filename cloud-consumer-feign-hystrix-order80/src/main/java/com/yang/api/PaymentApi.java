package com.yang.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentFallbackApiImpl.class)
public interface PaymentApi {
	@GetMapping("/payment/hystrix/ok/{id}")
	public String payment_OK(@PathVariable("id") Integer id);
	
	@GetMapping("/payment/hystrix/timeOut/{id}")
	public String payment_TimeOut(@PathVariable("id") Integer id);
}
