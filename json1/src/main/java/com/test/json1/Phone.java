package com.test.json1;

public class Phone {
	private String type;
	private String phNumber;
	
	
	public Phone() {}
	public Phone(String type, String phNumber) {
		this.type = type;
		this.phNumber = phNumber;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	
	
}
