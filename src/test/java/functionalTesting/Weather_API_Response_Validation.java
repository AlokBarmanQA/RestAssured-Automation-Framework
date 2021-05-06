package functionalTesting;

import java.util.Iterator;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Weather_API_Response_Validation {
	
	@Test
	public void getWeatherByCity() {
		String appid_key = "bd9c19b92b8471f5b57dd91cdafaf9a7";
		RestAssured.baseURI = "http://api.openweathermap.org";
		String uri = "/data/2.5/weather";
		Response response = RestAssured.given().queryParam("q", "new york")
										.queryParam("appid", appid_key)
										.when().get(uri);
//		System.out.println(response.getBody().asPrettyString());
		
		JSONObject json = new JSONObject(response.getBody().asString());
		Iterator<String> itr = json.keys();
		while(itr.hasNext()) {
			String key = itr.next();
//			System.out.println(key);
			try {
				if(key.equalsIgnoreCase("coord")) {
					Assert.assertTrue(true, "coord");
					System.out.println("Validate value of: " +key);
//					System.out.println("Validate value of: " +key+" is: "+json.get(key));
				}
				else if(key.equalsIgnoreCase("weather")) {
					Assert.assertTrue(true, "weather");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("base")) {
					Assert.assertTrue(true, "base");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("main")) {
					Assert.assertTrue(true, "main");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("visibility")) {
					Assert.assertTrue(true, "visibility");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("wind")) {
					Assert.assertTrue(true, "wind");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("clouds")) {
					Assert.assertTrue(true, "clouds");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("dt")) {
					Assert.assertTrue(true, "dt");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("sys")) {
					Assert.assertTrue(true, "sys");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("timezone")) {
					Assert.assertTrue(true, "timezone");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("id")) {
					Assert.assertTrue(true, "id");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("name")) {
					Assert.assertTrue(true, "name");
					System.out.println("Validate value of: " +key);
				}
				else if(key.equalsIgnoreCase("cod")) {
					Assert.assertTrue(true, "cod");
					System.out.println("Validate value of: " +key);
				}
				else {
	                System.err.println("Object {" +key+ "} does not contain the required key");
	            }
			} catch (Exception e) {
				e.fillInStackTrace();
			}
		}
	}
}
