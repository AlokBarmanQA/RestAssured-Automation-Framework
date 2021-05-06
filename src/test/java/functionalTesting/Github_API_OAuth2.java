package functionalTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Github_API_OAuth2 {
	// https://docs.github.com/en/rest/reference/repos#list-repositories-for-the-authenticated-user
	
	String accessToken = "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 ";
	@Test
	public void github_access_token_test() {
		RestAssured.baseURI = "https://api.github.com";
		String uri = "/user/repos";
		RestAssured.given()
							.auth().oauth2(accessToken)
							.param("sort", "created")
							.param("direction", "desc")
							.accept("application/json")
							.when().get(uri)
							.then().log().body();
	}
	@Test
	public void get_repo_of_specific_user() {
		RestAssured.baseURI = "https://api.github.com";
		String uri = "/users/{username}/repos";
		RestAssured.given().auth().oauth2(accessToken)
							.pathParam("username", "AlokBarmanQA")
							.when().get(uri)
							.then().log().body();
	}
}
