package com.test.jaxb.json1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class App {
	public static void main(String[] args) {

		try {
			System.out.println(new File(".").getAbsoluteFile());
			JsonReader jreader = Json.createReader(new FileReader("cust.info"));
			JsonObject customerObj = jreader.readObject();
			Customer customer = new Customer();
			customer.setCustId(customerObj.getInt("custId"));
			customer.setFirstName(customerObj.getString("firstName"));
			customer.setLastName(customerObj.getString("lastName"));
			JsonObject addressObj = customerObj.getJsonObject("address");
			Address address = new Address();
			address.setAddressLine1(addressObj.getString("addressLine1"));
			address.setAddressLine2(addressObj.getString("addressLine2"));
			address.setCity(addressObj.getString("city"));
			address.setZipcode(addressObj.getString("zipcode"));
			customer.setAddress(address);
			JsonArray phoneArray = customerObj.getJsonArray("phoneNumbers");
			String[] phones = new String[phoneArray.size()];
			int index = 0;
			for (JsonValue value : phoneArray) {
				phones[index++] = value.toString();
			}
			customer.setPhoneNumbers(phones);

			System.out.println(customer);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
