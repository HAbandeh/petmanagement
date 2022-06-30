package com.cobra.petmanagement.configurations;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import com.cobra.petmanagement.filters.AuthenticationFilter;
import com.cobra.petmanagement.services.ProdLoggingService;
import com.cobra.petmanagement.services.QALoggingService;

@Configuration
public class Config {

	
	@Bean
	FilterRegistrationBean<AuthenticationFilter> authenticationFilter(){
		
		FilterRegistrationBean<AuthenticationFilter> filterRegistrationBean = new FilterRegistrationBean<AuthenticationFilter>();
		filterRegistrationBean.setFilter(new AuthenticationFilter());
		filterRegistrationBean.setName("Auth Filter");
		filterRegistrationBean.addUrlPatterns("/");
		return filterRegistrationBean;
		
	}
	
	
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
	
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
