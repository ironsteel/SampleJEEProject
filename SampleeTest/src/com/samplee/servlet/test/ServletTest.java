package com.samplee.servlet.test;

import static org.junit.Assert.*;

import javax.xml.ws.WebEndpoint;

import com.samplee.*;

import com.sun.jersey.api.client.*;
import org.junit.Test;

public class ServletTest {

	@Test
	public void testServletResponse() {
		Client client = Client.create();

		// Fetch resource form servlet
		WebResource webResource = client
				.resource("http://localhost:8080/SampleeWeb/API/helloworld");

		// We are expecting a string containing "hello from servlet"
		assertEquals("hello from servlet", webResource.get(String.class));
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
	public void testServletReturnsSampleModelUsingEquals() {
		SampleModel obj = new SampleModel();
		Client client = Client.create();
		// Fetch resource form servlet
		WebResource webResource = client
				.resource("http://localhost:8080/SampleeWeb/API/samplemodel");
		SampleModel result = webResource.get(SampleModel.class);
		
		
		assertEquals(obj, result);
	}
}
