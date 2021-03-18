package com.shanemholland.utilities.kafkatester;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootApplication
public class KafkaTesterApplication {
	
	@Value("${kafka.tester.consumer.topic}")
	private String kafkaTestTopic;

	public static void main(String[] args) {
		SpringApplication.run(KafkaTesterApplication.class, args);
	}
	
	@Bean
	public NewTopic testTopic() {
	    return new NewTopic(kafkaTestTopic, 1, (short) 1);
	}

}
