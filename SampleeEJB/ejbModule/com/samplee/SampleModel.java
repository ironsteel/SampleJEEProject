package com.samplee;


import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SampleModel {
	
	
	private String name;
	
	public SampleModel() { 
		name = new String("Hello from json");
	}
	
	public String getName() {
		return name;
	}

	
}
