package functionalTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Post_Request_Products {
	
	@Test
	public void post_request_test() {
		RestAssured.baseURI = "http://localhost:3000";
		
		RestAssured.given()
							.body("[\r\n" + 
									"	{\r\n" + 
									"		\"id\": 1,\r\n" + 
									"		\"title\": \"json-server\",\r\n" + 
									"		\"author\": \"typicode\"\r\n" + 
									"	},\r\n" + 
									"	{\r\n" + 
									"		\"id\": 2,\r\n" + 
									"		\"title\": \"test-automation\",\r\n" + 
									"		\"author\": \"alok\"\r\n" + 
									"	}\r\n" + 
									"]")
							.post("/post")
							.then()
							.log()
							.all()
							.statusCode(201);
	}
}
