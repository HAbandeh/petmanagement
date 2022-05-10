package com.cobra.petmanagement.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.cobra.petmanagement.services.ProdLoggingService;
import com.cobra.petmanagement.services.QALoggingService;

@Configuration
public class Config {

	@Bean
	@Profile("QA")
	QALoggingService qaLoggingService() {
		return new QALoggingService();
	}
	
	@Bean
	//@Primary
	@Profile("PROD")
	ProdLoggingService prodLoggingService() {
		return new ProdLoggingService();
	}

}
