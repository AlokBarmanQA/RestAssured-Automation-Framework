package functionalTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Post_Request_01 {
	
	@Test
	public void post_request_test() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		Response response = RestAssured.given()
							.body("{\r\n" + 
									"    \"name\": \"alok\",\r\n" + 
									"    \"job\": \"sdet\"\r\n" + 
									"}")
							.post();
		
		JsonPath extract = response.jsonPath();
		String name = extract.get("name");
		String job = extract.get("job");
		Assert.assertEquals(name, "alok");
		Assert.assertEquals(job, "sdet");
	}
}
