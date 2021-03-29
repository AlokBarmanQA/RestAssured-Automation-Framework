package functionalTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Request_02 {
	
	@Test
	public void get_request_test() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		Response response = RestAssured.given()
							.param("page", 2)
							.when()
							.get();
		System.out.println(response.getBody().asString());
		System.out.println("Response code: " + response.getStatusCode());
		System.out.println("Content type: " + response.getContentType());
		System.out.println("Response time: " + response.getTime());
		System.out.println("Cookies: " + response.getCookies());
		System.out.println("Response in pretty format: " + response.prettyPrint());
	}
}
