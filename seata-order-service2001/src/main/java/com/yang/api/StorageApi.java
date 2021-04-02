package com.yang.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yang.entity.CommonResult;

@FeignClient(value = "seata-storage-service")
public interface StorageApi {
	@PostMapping("/storage/sub")
	public CommonResult<?> sub(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count);
}
