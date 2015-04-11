package com.test.jaxb.json1;

import javax.json.JsonObject;

public class Customer {
	private int custId;
	private String firstName;
	private String lastName;
	boolean regular;
	private Address address;
	private Phone[] phoneNumbers;

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

	public Phone[] getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Phone[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustId " + custId + "\n");
		builder.append("FirstName " + firstName + "\n");
		builder.append("LastName " + lastName + "\n");
		builder.append("Regular " + regular + "\n");
		builder.append("Address " + "\n" + address.toString() + "\n");
		builder.append("PhoneNumbers >> ");
		for (int i = 0; i < phoneNumbers.length; ++i) {
			builder.append(" "+ phoneNumbers[i].getType() + ":"
					+ phoneNumbers[i].getPhNumber());
		}
		return builder.toString();
	}

}
