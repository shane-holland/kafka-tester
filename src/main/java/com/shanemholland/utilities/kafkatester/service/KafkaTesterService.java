package com.shanemholland.utilities.kafkatester.service;

import com.shanemholland.utilities.kafkatester.producer.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaTesterService {
	
	@Autowired
	private KafkaMessageProducer producer;

	public void sendKafkaMessage(String topic, String message) {
		producer.produceKafkaMessage(topic, message);
	}
}
