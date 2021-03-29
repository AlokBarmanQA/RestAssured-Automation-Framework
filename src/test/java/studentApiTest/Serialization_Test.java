package studentApiTest;

import org.testng.annotations.Test;

import base.TestBase;
import configuration.APIEnpoints;
import configuration.HeaderConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.PostAPIPojo;
import utilities.JavaUtilities;

public class Serialization_Test extends TestBase{
	@Test
	public void serialization_test() {
		HeaderConfig headerObject = new HeaderConfig();
		PostAPIPojo pojoObject = new PostAPIPojo(JavaUtilities.generateRandomString(), JavaUtilities.generateRandomString(), 
				2, Integer.parseInt(JavaUtilities.generateRandomNumber()));
		Response response = RestAssured.given()
														.when()
														.headers(headerObject.defaultHeaders())
														.body(pojoObject)
														.post(APIEnpoints.allAPIEndpoints.CREATE_SINGLE_USER);
		System.out.println(response.getBody().asString());
		System.out.println(pojoObject.getFirstName());
		System.out.println(pojoObject.getLastName());
		System.out.println(pojoObject.getSubjectID());
		System.out.println(pojoObject.getId());
	}
}
