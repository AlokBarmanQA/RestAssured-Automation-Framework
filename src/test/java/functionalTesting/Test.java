package functionalTesting;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test {
	
	public static void get_call() {
		RestAssured.baseURI = "";
		Response response = RestAssured.given()
							.param("page", "2")
							.when()
							.get("end point");
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		JSONArray array = new JSONArray(response.getBody().asPrettyString());
		for(int i=0; i<array.length(); i++) {
			JSONObject json = array.getJSONObject(i);
			json.get("FirstName");
		}
	}
	public static void post_call() {
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("id", 3);
		payload.put("FirstName", "Aaaaa");
		payload.put("LastName", "Bbbbb");
		payload.put("SubjectID", 5);
		
		RestAssured.baseURI = "";
		Response response = RestAssured.given()
															.when()
														    .header("Content-Type", "application/json")
														    .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJz")
															.header("Access_Token", "asdfggjklzxcvbnm")
															.body(payload)
															.post("end point");
		System.out.println(response.getTime());
		System.out.println(response.getStatusCode());
		JSONArray array = new JSONArray(response.getBody().asPrettyString());
		for(int i=0; i<array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			obj.get("FirstName");
		}
		
		JSONObject json = new JSONObject(response.getBody().asPrettyString());
		if(json.has("key") && json.get("key") != null) {
			System.out.println("Pass: ");
		}
		
	    // Get JSON Representation from Response Body 
	    JsonPath jsonPathEvaluator = response.jsonPath();
	    // Get specific element from JSON document 
	    String firstName = jsonPathEvaluator.get("firstName");
	    // Validate if the specific JSON element is equal to expected value
	    Assert.assertTrue(firstName.equalsIgnoreCase("Sergey"));
	}
	public static void delete_call() {
		RestAssured.baseURI = "";
		Response response = RestAssured.given().when().delete("end point");
		System.out.println(response.getStatusCode());
	}
}
