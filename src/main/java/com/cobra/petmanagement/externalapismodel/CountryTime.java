package com.cobra.petmanagement.externalapismodel;

public class CountryTime {
	
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Time is " + data;
	}
	

}
