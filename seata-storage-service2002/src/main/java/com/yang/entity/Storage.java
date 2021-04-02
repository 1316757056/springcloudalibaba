package com.yang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {


    private Integer id;
 
    // 产品id
    private Integer productId;
 
    //总库存
    private Integer total;
 
 
    //已用库存
    private Integer used;
 
  
    //剩余库存
    private Integer residue;
}
