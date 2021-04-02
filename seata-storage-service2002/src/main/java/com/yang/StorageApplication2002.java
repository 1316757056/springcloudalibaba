package com.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.yang.mapper")
public class StorageApplication2002 {
	public static void main(String[] args) {
		SpringApplication.run(StorageApplication2002.class, args);
	}
}
