package com.yang.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yang.entity.Payment;
@Mapper
public interface PaymentMapper {
	
	boolean save(Payment payment);
	
	Payment findById(Integer id);
	
}
