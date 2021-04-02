package com.yang.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor{
	
	String INPUT1 = "input1";
	String OUTPUT = "output";

	@Input(MyProcessor.INPUT1)
	SubscribableChannel input1();
	
	@Output(Source.OUTPUT)
	MessageChannel output();
}
