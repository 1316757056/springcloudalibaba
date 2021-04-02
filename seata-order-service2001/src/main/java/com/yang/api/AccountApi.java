package com.yang.api;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yang.entity.CommonResult;

@FeignClient(value = "seata-account-service")
public interface AccountApi {
	@PostMapping("/account/sub")
    public CommonResult<?> sub(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money);
}
