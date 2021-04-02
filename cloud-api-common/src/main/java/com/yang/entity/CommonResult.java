package com.yang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yxf
 *
 * 返回值包装类
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
	
	//状态码
	private Integer code;
	//返回消息
	private String messsage;
	//如果有数据则封装到data中
	private T data;
	
	public CommonResult(Integer code, String messsage) {
		this.code = code;
		this.messsage = messsage;
	}
	
	
}
