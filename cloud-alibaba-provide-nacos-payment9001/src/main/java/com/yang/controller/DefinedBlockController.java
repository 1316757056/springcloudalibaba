package com.yang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yang.entity.CommonResult;
import com.yang.myhandler.MyBlockHandler;

@RestController
public class DefinedBlockController {
	
	@GetMapping("/defined")
	@SentinelResource(value = "defined",blockHandlerClass = MyBlockHandler.class,blockHandler = "blockHandler2")
	public CommonResult<String> defined(){
		return new CommonResult<String>(200, "defined");
	}
}
