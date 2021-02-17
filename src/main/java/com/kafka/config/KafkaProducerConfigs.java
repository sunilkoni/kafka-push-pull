package com.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfigs {
	
	private static final String KAFKA_BROKER = "localhost:9092";
	
	@Bean
	public ProducerFactory<String, String> producerFactory()
	{
		return new DefaultKafkaProducerFactory<String, String>(producerConfigs());
	}

	private Map<String, Object> producerConfigs() {
		HashMap<String, Object> producerConfigMap = new HashMap<String, Object>();
		producerConfigMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
		producerConfigMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfigMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return producerConfigMap;
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate()
	{
		return new KafkaTemplate<String, String>(producerFactory());
	}
}
