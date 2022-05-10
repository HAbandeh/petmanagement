package com.cobra.petmanagement.services;

import org.springframework.context.annotation.Primary;

// instead of @Service it is inside the config class
@Primary
public class ProdLoggingService implements LogginService{

	public void log(String msg) {
		System.out.println("Production " + msg);
	}
}
