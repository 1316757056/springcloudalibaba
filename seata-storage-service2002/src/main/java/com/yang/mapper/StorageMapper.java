package com.yang.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface StorageMapper {
	
	@Update("UPDATE t_storage SET used = used + #{count},residue = residue - #{count} WHERE product_id = #{productId}")
	void sub(@Param("productId") Integer productId,@Param("count") Integer count);
}
