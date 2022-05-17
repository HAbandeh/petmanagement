package com.cobra.petmanagement.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cobra.petmanagement.externalapismodel.CountryTime;

@Service
public class ExternalAPIServiceImple implements ExternalAPIService{
	
	LogginService logginService;
	RestTemplate restTemplate;
	String URI;
	
	public ExternalAPIServiceImple(RestTemplate restTemplate, LogginService logginService, @Value("${api.url}") String URI) {
		this.restTemplate = restTemplate;
		this.logginService = logginService;
		this.URI = URI;
	}
	
	public void printExternalUsers() {
		
		UriComponentsBuilder uriComponensBuilder = UriComponentsBuilder.fromUriString(URI);
		//.queryParam("limit", 3);
		
		CountryTime data =  restTemplate.getForObject(uriComponensBuilder.toUriString(), CountryTime.class);
		
		logginService.log(data.toString());
		
	}

}
