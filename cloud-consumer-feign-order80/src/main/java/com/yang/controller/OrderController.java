package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yang.api.PaymentApi;
import com.yang.entity.CommonResult;
import com.yang.entity.Payment;

@RestController
public class OrderController {
	
	@Autowired
	private PaymentApi paymentApi;
	
	@GetMapping("/consumer/payment/find/{id}")
	public CommonResult<?> find(@PathVariable("id") Integer id){
		return paymentApi.find(id);
	}
	
	@GetMapping("/consumer/payment/save")
	public CommonResult<?> find(Payment payment){
		return paymentApi.save(payment);
	}
	
	@GetMapping("/consumer/payment/timeout")
	public CommonResult<?> timeout(){
		return paymentApi.timeout();
	}
}
