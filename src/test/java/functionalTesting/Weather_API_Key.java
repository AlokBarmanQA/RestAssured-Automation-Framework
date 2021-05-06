package functionalTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Weather_API_Key {
	
	String key = "bd9c19b92b8471f5b57dd91cdafaf9a7";
	String url = "http://api.openweathermap.org/data/2.5/weather";
	@Test
	public void getWeatherByCityName() {
		Response response = RestAssured.given()
										.queryParam("q", "pennsylvania")
										.queryParam("appid", key)
										.when()
										.get(url);
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getHeaders());
//		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(200, response.getStatusCode());
	}
	@Test
	public void validateCountry() {
		String country = RestAssured.given()
															.queryParam("q", "pennsylvania")
															.queryParam("appid", key)
															.when()
															.get(url)
															.then().extract().path("sys.country");
		System.out.println(">>"+country);
		Assert.assertEquals(country, "US");
	}
	@Test
	public void validateWeather() {
		String mainWeather = RestAssured.given()
															.queryParam("q", "pennsylvania")
															.queryParam("appid", key)
															.when()
															.get(url)
															.then()
															.extract().path("weather[0].main");
		System.out.println(mainWeather);
		Assert.assertEquals(mainWeather, "Clouds");
	}
	@Test
	public void validateServerHeader() {
		RestAssured.given()
							.param("q", "pennsylvania")
							.param("appid", key)
							.when()
							.get(url)
							.then()
							.assertThat().header("Server", "openresty");
	}
	@Test
	public void validateContentTypeHeader() {
		RestAssured.given()
							.param("q", "pennsylvania")
							.param("appid", key)
							.when().get(url)
							.then().assertThat()
							.header("Content-Type", "application/json; charset=utf-8");
	}
}
