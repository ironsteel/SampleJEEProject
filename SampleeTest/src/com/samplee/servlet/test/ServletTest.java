package com.samplee.servlet.test;

import static org.junit.Assert.*;

import javax.ws.rs.core.MultivaluedMap;


import com.samplee.*;

import com.sun.jersey.api.client.*;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import org.junit.Test;

public class ServletTest {

	@Test
	public void testServletResponse() {
		Client client = Client.create();

		// Fetch resource form servlet
		WebResource webResource = client
				.resource("http://localhost:8080/SampleeWeb/API/helloworld");

		// We are expecting a string containing "hello from servlet"
		assertEquals("Hello from servlet", webResource.get(String.class));
	}
	
	@Test 
	public void testServletReturnsSampleModel() {
		Client client = Client.create();
		// Fetch resource form servlet
		WebResource webResource = client
				.resource("http://localhost:8080/SampleeWeb/API/samplemodel");
		SampleModel result = webResource.get(SampleModel.class);
		// Do we get the expected object
		assertEquals(SampleModel.class, result.getClass());
		
		// And does the name field contains the correct string value
		assertEquals("Hello from json", result.getName());	
	}
	
	
	
	@Test
	public void testCRUDOperations() {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/SampleeWeb/API/insert/name");
		webResource.post();
		
		webResource = client.resource("http://localhost:8080/SampleeWeb/API/getmodel/0");
		SampleModel obj = webResource.get(SampleModel.class);
		
		webResource = client.resource("http://localhost:8080/SampleeWeb/API/update/0/Rangel");
		webResource.put();	
		
		webResource = client.resource("http://localhost:8080/SampleeWeb/API/getmodel/0");
		obj = webResource.get(SampleModel.class);
		
	}
	
	@Test
	public void testServletReturnsSampleModelUsingEquals() {
		SampleModel obj = new SampleModel();
		obj.setName("Rangel");
		Client client = Client.create();
		// Fetch resource form servlet
		WebResource webResource = client
				.resource("http://localhost:8080/SampleeWeb/API/getmodel/0");
		SampleModel result = webResource.get(SampleModel.class);
		
		
		assertEquals(obj, result);
	}
}
