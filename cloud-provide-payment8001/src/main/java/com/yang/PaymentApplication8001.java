package com.yang;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication8001 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication8001.class, args);
	}
}
