package com.yang;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yang.mapper.AccountMapper;



@SpringBootTest
class TestApplicationTests {
	
	@Autowired
	AccountMapper accountMapper;
	@Test
	void contextLoads() throws SQLException {
		System.err.println(accountMapper.getClass());
	}
}
