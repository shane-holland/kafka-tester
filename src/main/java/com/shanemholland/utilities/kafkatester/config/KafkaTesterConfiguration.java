package com.shanemholland.utilities.kafkatester.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class KafkaTesterConfiguration {
	
	@Bean
	public Docket springBootSwaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
	            .apis(requestHandlers())
	            .paths(paths())
	            .build().apiInfo(metaData());
	}

	private Predicate<RequestHandler> requestHandlers() {
		return RequestHandlerSelectors.withClassAnnotation(RestController.class);
	}
	
	private Predicate<String> paths() {
		return Predicates.alwaysTrue();
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("PatientPay APIs")
				.description("API Documentation for a PatientPay Service")
				.termsOfServiceUrl("https://www.patientpay.com/terms-of-service")
				.version(getClass().getPackage().getImplementationVersion())
				.contact(new Contact("PatientPay","https://www.patientpay.com/", "support@patientpay.com"))
				.build();
	}
}
