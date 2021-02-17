package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String MY_KAFKA_TOPIC = "myTopic";
	
	public void produce(String message)
	{
		kafkaTemplate.send(MY_KAFKA_TOPIC, message);
		System.out.println("Produced "+message);
	}
}
