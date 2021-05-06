package authentications;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Basic_Authentication_Test {
	
	@Test
	public void basic_preemtive_Authentication() {
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		RestAssured.given().auth().preemptive().basic("postman", "password")
							.when().get()
							.then().log().body();
	}
	
	@Test
	public void basic_challenged_Auth() {
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		RestAssured.given().auth().basic("postman", "password")
		 					.when().get()
		 					.then().log().body();
	}
	
	@Test
	public void validate_basic_preemtive_Authentication() {
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		Response response = RestAssured.given().auth().preemptive().basic("postman", "password")
							.when().get();
		JsonPath json = response.jsonPath();
		json.get("authenticated");
	}
}
