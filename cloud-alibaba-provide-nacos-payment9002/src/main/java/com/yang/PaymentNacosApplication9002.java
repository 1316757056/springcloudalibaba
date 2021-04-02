package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosApplication9002 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentNacosApplication9002.class, args);
	}
}
