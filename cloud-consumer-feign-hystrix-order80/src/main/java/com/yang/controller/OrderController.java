package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yang.api.PaymentApi;

@RestController
//@DefaultProperties(defaultFallback = "payment_Global_TimeOutHandle")
public class OrderController {
	
	@Autowired
	private PaymentApi paymentApi;
	
	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	public String payment_OK(@PathVariable("id") Integer id) {
		return paymentApi.payment_OK(id);
	}
	
	@GetMapping("/consumer/payment/hystrix/timeOut/{id}")
//	@HystrixCommand(fallbackMethod = "payment_TimeOutHandle",commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"))
//	@HystrixCommand
	public String payment_TimeOut(@PathVariable("id") Integer id) {
		return paymentApi.payment_TimeOut(id);
	}
	
	public String payment_TimeOutHandle(Integer id) {
		return "我是消费者80，对方支付系统繁忙或程序出错，/(ㄒoㄒ)/~~";
	}
	
	public String payment_Global_TimeOutHandle() {
		return "我是消费者80全局服务降级方法，对方支付系统繁忙或程序出错，/(ㄒoㄒ)/~~";
	}
	
}
