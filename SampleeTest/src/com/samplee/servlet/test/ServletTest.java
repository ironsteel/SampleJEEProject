package com.samplee.servlet.test;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;




import com.samplee.*;

import com.sun.jersey.api.client.*;


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
	public void testNewOperation() {
		SampleModel obj = new SampleModel();
		obj.setId(0);
		obj.setName("Test");
		webResource.path("new").accept(MediaType.APPLICATION_JSON).post(obj);
		
		SampleModel storedObj = webResource.path("0").get(SampleModel.class);	
		assertEquals(obj, storedObj);
	}
	
	@Test
	public void testGetSampleModel() {
		SampleModel obj = new SampleModel();
		obj.setId(0);
		obj.setName("Test");
		
		SampleModel result = webResource.path("0").get(SampleModel.class);
		assertEquals(obj, result);
	}
	
	@Test
	public void testUpdateModel() {
		SampleModel replacement = new SampleModel();
		replacement.setName("New Name");
		replacement.setId(0);
		webResource.path("update").accept(MediaType.APPLICATION_JSON).put(replacement);
		
		SampleModel stored = webResource.path("0").get(SampleModel.class);
		
		assertEquals(stored, replacement);
		
	}
	
	@Test
	public void testDeleteModel() {
		webResource.path("0").delete();
		try {
			SampleModel stored = webResource.path("0").get(SampleModel.class);
			fail();
		} catch (UniformInterfaceException e) {
		}
		
	}
}
