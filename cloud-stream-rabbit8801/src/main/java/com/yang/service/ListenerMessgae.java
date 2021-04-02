package com.yang.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.yang.config.MyProcessor;

@Service
public class ListenerMessgae {
	
	@StreamListener(MyProcessor.INPUT1)
	public void recerive1(Message<String> message) {
		System.err.println("1号机接受到的消息是:"+message.getPayload());
	}
}
