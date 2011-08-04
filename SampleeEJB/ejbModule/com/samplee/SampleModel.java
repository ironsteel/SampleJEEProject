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
	
	public void setName(String nameArg) {
		name = nameArg;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		// If we pass the same object
		if(this == obj) {
			return true;
		}
		
		
		SampleModel lhs = (SampleModel) obj;
		
		// Do we get the same class
		if (getClass() != lhs.getClass()) {
		      return false;
		}
		
		if(!getName().equals(lhs.getName())) {
			return false;
		}
		
		return true;
		
	}

	
}
