package com.cobra.petmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import com.cobra.petmanagement.configurations.DatabaseConfig;


// instead of @Service it is inside the config class
@Primary
public class ProdLoggingService implements LogginService{

	
	private DatabaseConfig databaseConfig;
	

	@Autowired
	public void setDatabaseConfig(DatabaseConfig databaseConfig) {
		this.databaseConfig = databaseConfig;
	}
	
	public void log(String msg) {
		System.out.println("Production: " + msg);
		
		System.out.println(this.databaseConfig.getUrl());
		System.out.println(this.databaseConfig.getUserName());
		System.out.println(this.databaseConfig.getPassword());
	}
}
