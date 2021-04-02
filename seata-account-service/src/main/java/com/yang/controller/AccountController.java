package com.yang.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.entity.CommonResult;
import com.yang.mapper.AccountMapper;

@RestController
public class AccountController {
    @Autowired
    private AccountMapper accountMapper;
 
    /**
     * 扣减账户余额
     */
    @PostMapping("/account/sub")
    public CommonResult<?> sub(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money){
    	accountMapper.sub(userId,money);
        return new CommonResult<String>(200,"扣减账户余额成功！");
    }
}
