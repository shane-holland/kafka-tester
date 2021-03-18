package com.shanemholland.utilities.kafkatester.rest;

import com.shanemholland.utilities.kafkatester.service.KafkaTesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = {"Kafka Tester Application"})
@SwaggerDefinition (tags = {
	@Tag(name = "Kafka Tester Application", description = "Send a kafka message to a specified kafka topic")
})
@RestController
@RequestMapping("/kafka-tester")
public class KafkaTesterRest {
	
	@Autowired
	private KafkaTesterService service;
	
	@ApiOperation(
			value= "Kafka Message Utility", 
			notes= "Send a kafka message to a specified kafka topic")
	@PostMapping(path = "/message/{topic}", consumes = "application/json")
	public void sendKafkaMessage(
			@PathVariable(name = "topic", required = true) final String topic,
			@RequestBody(required = true) final String message) {
		
		service.sendKafkaMessage(topic, message);
	}
}
