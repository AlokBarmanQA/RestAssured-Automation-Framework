package functionalTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Get_Request_01 {
	
	@Test
	public void get_request_test() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured.given()
							.param("page", 2)
							.when()
							.get()
							.then()
							.log()
							.all()
							.statusCode(200);
	}
}
