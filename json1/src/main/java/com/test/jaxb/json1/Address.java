package com.test.jaxb.json1;

public class Address {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zipcode;
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressLine1 " +addressLine1 + "\n");
		builder.append("AddressLine2 "+addressLine2 + "\n");
		builder.append("city " +city + "\n");
		builder.append("Zipcode " +zipcode + "\n");
		return builder.toString();
	}
	
}
