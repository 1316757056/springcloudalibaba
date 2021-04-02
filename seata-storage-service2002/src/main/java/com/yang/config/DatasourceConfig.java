package com.yang.config;


import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.seata.rm.datasource.DataSourceProxy;

@Configuration
public class DatasourceConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource datasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public DataSourceProxy dataSourceProxy() {
		 return new DataSourceProxy(datasource());
	}
	
	@Bean
	@Primary
	public SqlSessionFactoryBean sessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSourceProxy());
		sessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
		return sessionFactoryBean;
	}
	
}
