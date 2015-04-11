package com.test.jaxb.jaxb_accesstype;
import javax.xml.bind.annotation.XmlAttribute;

public class Emp {
	private String fieldA;
	 
    @XmlAttribute
    private String fieldB;
 
    public String fieldC;
 
    @XmlAttribute
    public String getPropertyA() {
        return fieldA;
    }
 
    public void setPropertyA(String a) {
        this.fieldA = a;
    }
 
    public String getPropertyB() {
        return fieldB;
    }
 
    public void setPropertyB(String b) {
        this.fieldB = b;
    }

	
    
}
