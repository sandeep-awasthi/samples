package com.test.json1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class JsonWriterModelApi {

	public static void main(String[] args) throws IOException {
		System.out.println(new File(".").getAbsoluteFile());
		JsonWriter jwriter = Json
				.createWriter(new FileWriter("cust_output.info"));
		JsonObject customerObj = Json
				.createObjectBuilder()
				.add("custId", 05)
				.add("firstName", "Sandeep")
				.add("lastName", "Awasthi")
				.add("regular", true)
				.add("Address",
						Json.createObjectBuilder()
								.add("addressLine1", "AB/10, Example Building")
								.add("addressLine2", "Example Street")
								.add("city", "Example city")
								.add("zip", "12345"))
				.add("phoneNumbers",
						Json.createArrayBuilder()
								.add(Json.createObjectBuilder()
										.add("type", "mobile")
										.add("number", "111-111-1111"))
								.add(Json.createObjectBuilder()
										.add("type", "home")
										.add("number", "222-222-2222")))
				.build();
		jwriter.writeObject(customerObj);
		jwriter.close();

	}

}
