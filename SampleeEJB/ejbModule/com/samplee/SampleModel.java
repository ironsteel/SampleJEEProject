package com.samplee;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
@NamedQueries(value = {
		@NamedQuery(name = SampleModel.GET_SAMPLEMODEL_ALL, query = "SELECT m FROM SampleModel m"),
		@NamedQuery(name = SampleModel.GET_SAMPLEMODEL_BY_NAME, query = "SELECT m FROM SampleModel m WHERE m.name = :name")
		})
public class SampleModel implements Serializable {
	
	public static final String GET_SAMPLEMODEL_BY_NAME = "getSampleModelByName";
	
	public static final String GET_SAMPLEMODEL_ALL = "getAll";
	
	
	@Id
	@Column()
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name", updatable = true)
	private String name;
	
	public SampleModel() { 
		
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
