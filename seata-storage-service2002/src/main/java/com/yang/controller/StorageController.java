package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.entity.CommonResult;
import com.yang.mapper.StorageMapper;

@RestController
public class StorageController {
	
	@Autowired
	private StorageMapper storageMapper;
	
	   //扣减库存
    @PostMapping("/storage/sub")
    public CommonResult<?> sub(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count) {
    	storageMapper.sub(productId, count);
        return new CommonResult<String>(200,"扣减库存成功！");
    }
	
}
