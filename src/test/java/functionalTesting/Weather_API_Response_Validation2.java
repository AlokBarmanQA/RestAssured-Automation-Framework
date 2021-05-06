package functionalTesting;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Weather_API_Response_Validation2 {
	
	@Test
	public void getWeatherByCity() {
		String appid_key = "bd9c19b92b8471f5b57dd91cdafaf9a7";
		RestAssured.baseURI = "http://api.openweathermap.org";
		String uri = "/data/2.5/weather";
		Response response = RestAssured.given().queryParam("q", "new york")
										.queryParam("appid", appid_key)
										.when().get(uri);
		System.out.println(response.getBody().asPrettyString());
		
//		JSONObject json = new JSONObject(response.getBody().asString());
		JsonPath json = response.jsonPath();
		String coord = json.get("base");
		System.out.println(coord);
/*		try {
			if(json.has("coord") && json.get("coord") != null) {
				String coord = json.get("coord");
//				Assert.assertEquals(json.get("coord"), "coord");
			}
		} catch (Exception e) {
			System.out.println("Key is not available");
		}*/
/*		else if(json.has("weather")) {
			Assert.assertEquals(json.get("weather"), "weather");
		}*/
	}
}
