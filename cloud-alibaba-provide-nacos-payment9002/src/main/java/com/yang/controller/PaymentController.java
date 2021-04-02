package com.yang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/find/{id}")
	public String find(@PathVariable("id") int id) {
		return  "服务器调用成功，server port="+port+"\t id="+id;
	}
}
