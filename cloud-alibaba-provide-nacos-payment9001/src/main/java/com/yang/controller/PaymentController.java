package com.yang.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/find/{id}")
	public String find(@PathVariable("id") int id) {
		return  "服务器调用成功，server port="+port+"\t id="+id;
	}
	
	@GetMapping("/testA")
	public String testA() {
		log.info(Thread.currentThread()+"\t-------testA-------");
		return  "-----testA-----";
	}
	
	@GetMapping("/testB")
	public String testB() {
		return  "-----testB-----";
	}
	
	@GetMapping("/testC")
	public String testC() {
		log.info("超时-------testC-------");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  "-----testC-----";
	}
	
	@GetMapping("/testD")
	public String testD() {
		log.info("异常-------testD-------");
		int i = 10/0;
		return  "-----testD-----";
	}
	
	@GetMapping("/testE")
	@SentinelResource(value = "testE",blockHandler = "blockHandler")
	public String testE(@RequestParam(value = "p1",required = false) String p1,@RequestParam(value = "p2",required = false) String p2) {
		return  "-----testE-----";
	}
	
	public String blockHandler(String p1,String p2,BlockException blockException) {
		return "blockHandler  /(ㄒoㄒ)/~~";
	}
}
