package com.test.jaxb.json1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class JsonReaderModelApi {
	public static void main(String[] args) {

		try {
			System.out.println(new File(".").getAbsoluteFile());
			JsonReader jreader = Json.createReader(new FileReader("cust_input.info"));
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
			Phone[] phones = new Phone[phoneArray.size()];
			int index = 0;
			for (JsonValue value : phoneArray) {
				
				if (value.getValueType().equals(JsonValue.ValueType.OBJECT)) {
					JsonObject jobj = (JsonObject)value;
					Phone phone = new Phone();
					phone.setType(jobj.getString("type"));
					phone.setPhNumber(jobj.getString("phNumber"));
					phones[index++] = phone;
				}
				
					
				
			}
			customer.setPhoneNumbers(phones);

			System.out.println(customer);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
