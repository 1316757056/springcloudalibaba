package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.api.AccountApi;
import com.yang.api.StorageApi;
import com.yang.entity.CommonResult;
import com.yang.entity.Order;
import com.yang.mapper.OrderMapper;

import io.seata.spring.annotation.GlobalTransactional;

@RestController
public class OrderController {
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private AccountApi accountApi;
	
	@Autowired
	private StorageApi storageApi;
	
	@GetMapping("/order/create")
	@GlobalTransactional(name = "order",rollbackFor = Exception.class)
	public CommonResult<String> createOrder(Order order) {
		System.err.println(order);
		orderMapper.create(order);
		storageApi.sub(order.getProductId(), order.getCount());
		accountApi.sub(order.getUserId(), order.getMoney());
		orderMapper.update(order.getUserId());
		return new CommonResult<String>(200, "ok");
	}
}
