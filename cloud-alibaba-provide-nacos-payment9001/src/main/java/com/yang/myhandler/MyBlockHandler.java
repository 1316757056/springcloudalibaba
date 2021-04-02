package com.yang.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yang.entity.CommonResult;

public class MyBlockHandler {
	
	public static CommonResult<String> blockHandler(BlockException exception){
		return new CommonResult<String>(4444, "blockHandler1\t/(ㄒoㄒ)/~~");
	}

	public static CommonResult<String> blockHandler2(BlockException exception){
		return new CommonResult<String>(4444, "blockHandler2\t/(ㄒoㄒ)/~~");
	}
	
}
