package com.yang.api.fallback;

import org.springframework.stereotype.Component;

import com.yang.api.PaymentApi;

@Component
public class PaymentFallback implements PaymentApi{
	
	public String find(int id) {
		return "当前服务器繁忙，请稍后再试";
	}

}
