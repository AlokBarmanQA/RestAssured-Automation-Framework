package functionalTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DELETE_Request_01 {
	
	@Test
	public void delete_request_test_01() {
		RestAssured.baseURI = "http://localhost:3000/posts";
		
		RestAssured.given().when().delete("/posts/3").then().log().all();
	}
}
