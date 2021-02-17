package com.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.service.ConsumerService;
import com.kafka.service.ProducerService;

@RestController("/kafka")
public class KafkaController {


	@Autowired
	ProducerService producerService;
	@Autowired
	ConsumerService consumerService;
	
	@GetMapping("/send")
	public void sendGreetMessage(@RequestParam String message)
	{
		producerService.produce(message);
	}
	
	@GetMapping("/messages")
	public List<String> getMessages()
	{
		return consumerService.getMessages();
	}
}
