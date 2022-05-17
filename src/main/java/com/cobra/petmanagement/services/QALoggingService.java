package com.cobra.petmanagement.services;

// instead of @Service it is inside the config class
public class QALoggingService implements LogginService{

	@Override
	public void log(String msg) {
		System.out.println("QA: " + msg);
	}
}
