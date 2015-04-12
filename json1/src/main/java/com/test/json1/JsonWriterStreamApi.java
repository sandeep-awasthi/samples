package com.test.json1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class JsonWriterStreamApi {

	public static void main(String[] args) {
		System.out.println(new File(".").getAbsoluteFile());
		try {
			JsonGenerator jgenerator = Json.createGenerator(new FileWriter(
					"cust_output.info"));

			jgenerator.writeStartObject()
			.write("custId",2)
			.write("firstName","Sandeep")
			.write("lastName","Awasthi")
			.write("regular",true)
			.writeStartObject("Address")
			.write("addressLine1","AB/10, Example Building")
			.write("addressLine2","Example Street")
			.write("city","Example City")
			.write("zip","12345")
			.writeEnd()
			.writeStartArray("phoneNumbers")
			.writeStartObject()
			.write("type","home")
			.write("number","111-111-1111")
			.writeEnd()
			.writeStartObject()
			.write("type","mobile")
			.write("number","222-222-2222")
			.writeEnd()
			.writeEnd()
			.writeEnd();
			jgenerator.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
