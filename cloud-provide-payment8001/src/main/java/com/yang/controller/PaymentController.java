package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yang.entity.CommonResult;
import com.yang.entity.Payment;
import com.yang.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Value("${server.port}")
	private String port;
	
	@PostMapping("/payment/save")
	public CommonResult<String> save(@RequestBody Payment payment) {
		boolean save = paymentService.save(payment);
		if (save) {
			return new CommonResult<String>(200, "插入成功,port:"+port);
		}
		return new CommonResult<String>(500, "插入失败,port:"+port);
	}
	
	@GetMapping("/payment/find/{id}")
	public CommonResult<Payment> find(@PathVariable("id") Integer id) {
		Payment payment = paymentService.findById(id);
		if (payment!=null) {
			return new CommonResult<Payment>(200, "查询成功,port:"+port,payment);
		}
		return new CommonResult<Payment>(500, "没有该id,port:"+port);
	}
	
	@GetMapping("/payment/timeout")
	public CommonResult<Payment> timeout() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new CommonResult<Payment>(200,port);
	}
}
