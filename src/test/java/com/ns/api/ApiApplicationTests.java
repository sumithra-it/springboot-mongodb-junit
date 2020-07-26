package com.ns.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
//import static org.junit.jupiter.api.Assertions.assertThat; //this is old. Use JUNIT 5 assertTrue and assertEquals API instead
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	FruitService fruitService;
	
	@Test
	void testURL() throws IOException, ClientProtocolException{
		HttpUriRequest request = new HttpGet("http://localhost:8080/fruit");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		
		Assertions.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
	}
	
	//@Test
	//com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize instance of `com.ns.api.FruitModel` out of START_ARRAY token
	// at [Source: (String)"[{"id":"5ef51342db9e9a7403795710",
	//    "name":"bananna","color":"yellow","stock":75,"priceperpound":7.5}]"; line: 1, column: 1]
	 //    	at com.fasterxml.jackson.databind.exc.MismatchedInputException.from(MismatchedInputException.java:59)
	void testJSONResponse() throws IOException, ClientProtocolException{
		HttpUriRequest request = new HttpGet("http://localhost:8080/fruit");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		FruitModel fruit = RetreiveUtil.retrieveResourceFromResponse(httpResponse, FruitModel.class);
		assertEquals("bananna", Matchers.is(fruit.getName()));
	}
	

}
