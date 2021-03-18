package com.shanemholland.utilities.kafkatester.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shanemholland.utilities.kafkatester.exception.BadRequestException;

@Component
public class KafkaMessageProducer {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private KafkaTemplate<String, String> kafka;
	
	public void produceKafkaMessage(String topic, String message) {
		if (StringUtils.isEmpty(topic) || StringUtils.isEmpty(message)) {
			throw new BadRequestException("topic and message are both required and can not be empty or null");
		}
		
		LOGGER.info("Sending kafka message to topic={} with message={}", topic, message);
		kafka.send(topic, message);
	}
}
