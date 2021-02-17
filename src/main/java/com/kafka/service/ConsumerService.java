package com.kafka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	
	List<String> messages = new ArrayList<String>();

	@KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
	public void kafkaListener(String message) 
	{
		System.out.println("Consumed "+message);
		messages.add(message);
	}
	
	public List<String> getMessages()
	{
		 return messages;
	}
}
