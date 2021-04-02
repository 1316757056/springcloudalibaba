package com.yang.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer id;
 
    private Integer userId;
 
    private Integer productId;
 
    private Integer count;
 
    private BigDecimal money;
 
    private Integer status; //订单状态：0：创建中；1：已完结
}
