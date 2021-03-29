package functionalTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Post_Request_02 {
	
	@Test
	public void post_request_test() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		String post_body = "{\r\n" + "    \"name\": \"kumar\",\r\n" + "    \"job\": \"qa\"\r\n" + "}";
		
		RestAssured.given()
							.body(post_body)
							.post()
							.then()
							.log()
							.all()
							.statusCode(201);
	}
}
