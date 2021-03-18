package com.shanemholland.utilities.kafkatester.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@EnableKafka

public class KafkaMessageConsumer {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@KafkaListener(topics = "${kafka.tester.consumer.topic}")
	public void recieveKafkaMessage(@Payload String message, @Headers MessageHeaders messageHeaders) {
		
		logger.info("\n\n");
		logger.info("--------------------------------\n");
		
		logger.info(" Received Kafka message...\n\n");
		
		logger.debug("================================");
		logger.debug("=     Message Headers          =");
		logger.debug("================================");
		logger.debug("\n\n");
		
		messageHeaders.keySet().forEach(key -> {
            logger.debug("{}: ({})", key, messageHeaders.get(key));
        });
		
		logger.info("\n\n");
		logger.info("--------------------------------\n");
		
		logger.info("================================");
		logger.info("=     Message Payload          =");
		logger.info("================================");
		logger.info("\n\n");
		
		logger.info("({})", message);
		
		logger.info("\n\n");
		logger.info("--------------------------------");

	}
}
