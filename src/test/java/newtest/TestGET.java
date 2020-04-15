package newtest;

import org.testng.Assert;
import org.testng.annotations.Test;


import  io.restassured.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGET {

	@Test
	void testOne() {
		
		
		//REST Assured allows configuring the OAuth 2.0 access token
		//Token from https://gorest.co.in/rest-console.html
		String token ="8H3u2_PY667K7M9dGa_8wYBjSjif_MKo0zMu";
		
		RestAssured.baseURI = "https://gorest.co.in/public-api/users?first_name=Mario";

		//Define the specification of request
		RequestSpecification rsp = RestAssured.given();
		/*Get Response with 200 status code and token auth, I have found this on my own, 
		looking for similar online solution and about 30 min */
		Response response = rsp.auth().oauth2(token).when().
				get(RestAssured.baseURI);
		  	System.out.println(response.asString());
		    System.out.println(response.getStatusCode());
		    System.out.println(response.getContentType());
		    System.out.println(response.getHeaders());
		    int statusCode = response.getStatusCode();
	        
		    
		    Assert.assertEquals(statusCode, 200);
		
		    
	}

}
