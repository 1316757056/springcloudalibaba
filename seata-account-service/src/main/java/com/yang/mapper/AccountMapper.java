package com.yang.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {
	
	@Update("UPDATE t_account SET residue = residue - #{money},used = used + #{money} WHERE user_id = #{userId}")
	void sub(@Param("userId") Integer userId, @Param("money") BigDecimal money);

}
