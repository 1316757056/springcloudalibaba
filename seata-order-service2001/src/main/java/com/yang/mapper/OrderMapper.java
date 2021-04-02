package com.yang.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.yang.entity.Order;

public interface OrderMapper {
	
	@Insert("insert into t_order values(null,#{userId},#{productId},#{count},#{money},0)")
	void create(Order order);
	
	@Update(" update t_order set status = 1 where user_id=#{userId}")
	void update(@Param("userId") Integer userId);
}
