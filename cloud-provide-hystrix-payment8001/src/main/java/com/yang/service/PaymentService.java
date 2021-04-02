package com.yang.service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class PaymentService {
	
	public String payment_OK(Integer id) {
		return "线程池:"+Thread.currentThread().getName()+"payment_OK,id:"+id+"\t哈哈";
	}

	@HystrixCommand(fallbackMethod = "payment_TimeOutHandle",commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"))
	public String payment_TimeOut(Integer id) {
		int timeNumber = 3;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "线程池:"+Thread.currentThread().getName()+"payment_TimeOut,id:"+id+"\t呜呜呜 ,耗时(秒)"+timeNumber;
	}
	
	public String payment_TimeOutHandle(Integer id) {
		return "线程池:"+Thread.currentThread().getName()+"服务超时或异常,id:"+id+"\t呜呜呜" ;
	}
	
	@HystrixCommand(fallbackMethod = "payment_CircuitHandle",commandProperties = {
		@HystrixProperty(name = "circuitBreaker.enabled",value = "true"),	
		@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
		@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
		@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
	})
	public String payment_Circuit(Integer id) {
		if (id<0) {
			throw new RuntimeException();
		}
		return Thread.currentThread().getName()+"\t"+"调用成功，流水号"+UUID.randomUUID().toString();
	}
	
	public String payment_CircuitHandle(Integer id) {
		return "id不能为负数，请稍后再试，/(ㄒoㄒ)/~~ \t id="+id;
	}
}
