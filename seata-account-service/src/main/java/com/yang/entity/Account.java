package com.yang.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer id;
    
    /**
     * 用户id
     */
    private Integer userId;
 
    /**
     * 总额度
     */
    private BigDecimal total;
 
    /**
     * 已用额度
     */
    private BigDecimal used;
 
    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
