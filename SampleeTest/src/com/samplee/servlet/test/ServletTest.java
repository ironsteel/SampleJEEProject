package com.samplee.servlet.test;

import static org.junit.Assert.*;

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
}
