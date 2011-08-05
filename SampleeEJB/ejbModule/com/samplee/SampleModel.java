package com.samplee;


import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SampleModel {
	
	private static int count = 0;
	private Integer id = count++;
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
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer arg) {
		id = arg;
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
