package com.test.json1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

public class JsonReaderStreamApi {

	public static void main(String[] args) {
		System.out.println(new File(".").getAbsoluteFile());
		try {
			JsonParser jparser = Json.createParser(new FileReader(
					"cust_input.info"));

			while (jparser.hasNext()) {
				JsonParser.Event event = jparser.next();
				switch (event) {
				case START_ARRAY:
				case END_ARRAY:
				case START_OBJECT:
				case END_OBJECT:
				case VALUE_FALSE:
				case VALUE_NULL:
				case VALUE_TRUE:
					System.out.println(event.toString());
					break;
				case KEY_NAME:
					System.out.print(event.toString() + " "
							+ jparser.getString() + " - ");
					break;
				case VALUE_STRING:
				case VALUE_NUMBER:
					System.out.println(event.toString() + " "
							+ jparser.getString());
					break;
				}
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
