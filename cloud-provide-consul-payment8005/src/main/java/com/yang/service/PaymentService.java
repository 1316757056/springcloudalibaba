package com.yang.service;

import com.yang.entity.Payment;

public interface PaymentService {
	
	boolean save(Payment payment);
	
	Payment findById(Integer id);
}
