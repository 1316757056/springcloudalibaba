package com.yang.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.yang.config.MyProcessor;

@Component
public class MessageService {
	
	@Autowired
	private MyProcessor processor;
	
	public String sendMessage(){
		String id = UUID.randomUUID().toString();
		System.err.println("---------id:"+id);
		processor.output().send(MessageBuilder.withPayload(id).build());
		return id;
	}

}
