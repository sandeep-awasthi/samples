package com.test.jaxb.json1;

public class Customer {
	private int custId;
	private String firstName;
	private String lastName;
	boolean regular;
	private Address address;
	private String[] phoneNumbers;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isRegular() {
		return regular;
	}
	public void setRegular(boolean regular) {
		this.regular = regular;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	} 
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustId " +custId + "\n");
		builder.append("FirstName " +firstName + "\n");
		builder.append("LastName " +lastName + "\n");
		builder.append("Regular " +regular + "\n");
		builder.append("Address " +"\n"+address + "\n");
		builder.append("PhoneNumbers " +phoneNumbers[0] +","+phoneNumbers[1]+ "\n");
		return builder.toString();
	}

}
