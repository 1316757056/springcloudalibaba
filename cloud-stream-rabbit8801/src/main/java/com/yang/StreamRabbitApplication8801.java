package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.yang.config.MyProcessor;

@SpringBootApplication
@EnableBinding(value = MyProcessor.class)
public class StreamRabbitApplication8801 {
	
	public static void main(String[] args) {
		SpringApplication.run(StreamRabbitApplication8801.class, args);
	}
}
