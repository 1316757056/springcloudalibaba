package com.yang.api;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackApiImpl implements PaymentApi{

	@Override
	public String payment_OK(Integer id) {
		return "PaymentFallbackApiImpl/我是消费者80，对方支付系统繁忙或程序出错，/(ㄒoㄒ)/~~";
	}

	@Override
	public String payment_TimeOut(Integer id) {
		return "PaymentFallbackApiImpl/我是消费者80，对方支付系统繁忙或程序出错，/(ㄒoㄒ)/~~";
	}

}
