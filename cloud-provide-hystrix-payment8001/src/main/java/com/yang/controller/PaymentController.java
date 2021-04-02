package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yang.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payment/hystrix/ok/{id}")
	public String payment_OK(@PathVariable("id") Integer id) {
		String result = paymentService.payment_OK(id);
		log.info(result);
		return result;
	}
	
	@GetMapping("/payment/hystrix/timeOut/{id}")
	public String payment_TimeOut(@PathVariable("id") Integer id) {
		String result = paymentService.payment_TimeOut(id);
		log.info(result);
		return result;
	}
	
	@GetMapping("/payment/hystrix/circuit/{id}")
	public String payment_Circuit(@PathVariable("id") Integer id) {
		String result = paymentService.payment_Circuit(id);
		log.info(result);
		return result;
	}

}
