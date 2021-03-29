package functionalTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Post_Request_01 {
	
	@Test
	public void post_request_test() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RestAssured.given()
							.body("{\r\n" + 
									"    \"name\": \"alok\",\r\n" + 
									"    \"job\": \"sdet\"\r\n" + 
									"}")
							.post()
							.then()
							.log()
							.all()
							.statusCode(201);
	}
}
