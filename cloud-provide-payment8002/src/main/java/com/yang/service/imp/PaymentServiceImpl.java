package com.yang.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.entity.Payment;
import com.yang.mapper.PaymentMapper;
import com.yang.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentMapper paymentMapper;

	@Override
	public boolean save(Payment payment) {
		return paymentMapper.save(payment);
	}

	@Override
	public Payment findById(Integer id) {
		return paymentMapper.findById(id);
	}

}
