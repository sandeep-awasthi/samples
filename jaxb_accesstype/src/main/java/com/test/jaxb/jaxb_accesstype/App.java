package com.test.jaxb.jaxb_accesstype;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String args[]) {
		try {
			JAXBContext jc = JAXBContext.newInstance(Emp.class);
			Emp emp = new Emp();
			emp.setPropertyA("a");
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
