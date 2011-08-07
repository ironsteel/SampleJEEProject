package com.samplee.servlet.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.samplee.*;

import com.sun.jersey.api.NotFoundException;
import com.sun.jersey.api.client.*;


import org.apache.openjpa.persistence.NoResultException;
import org.junit.Before;
import org.junit.Test;

public class ServletTest {

	private WebResource webResource;

	@Before
	public void setUp() {
		Client client = Client.create();
		webResource = client.resource("http://localhost:8080/SampleeWeb/API/samplemodel");
	}
		
	@Test
	public void testNewOperatation() {
		SampleModel obj = new SampleModel();
		obj.setName("Test");
		webResource.path("new").accept(MediaType.APPLICATION_JSON).post(obj);
		
		SampleModel stored =  (SampleModel) webResource.path("Test").get(SampleModel.class);
		
		assertEquals(obj, stored);
		
	}
	
	
	@Test
	public void testGetSampleModelByName() {
		SampleModel result = (SampleModel) webResource.path("Test").get(SampleModel.class);
	}
	
	@Test
	public void testUpdateModel() {
		SampleModel obj = (SampleModel) webResource.path("Test").get(SampleModel.class);
		obj.setName("Test1");
		webResource.path("update").accept(MediaType.APPLICATION_JSON).put(obj);
		
		SampleModel stored = webResource.path("Test1").get(SampleModel.class);
		
		assertEquals(stored, obj);
		
	}
	
	@Test
	public void testDeleteModel() {
		SampleModel result  = webResource.path("Test1").get(SampleModel.class);
		
		webResource.path("delete/" + result.getName()).delete();
	}
	
	@Test
	public void testDeleteAll() {
		webResource.path("deleteall").delete();
	}
}
