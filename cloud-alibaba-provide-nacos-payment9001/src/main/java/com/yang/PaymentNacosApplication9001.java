package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosApplication9001 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentNacosApplication9001.class, args);
	}
}
