package studentApiTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiPayloads.POST_API_Payload;
import base.TestBase;
import configuration.APIEnpoints;
import configuration.HeaderConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.JavaUtilities;
import validation.ResponseVerification;

public class POST_API_Test_01 extends TestBase{
	
	@Test
	public void valid_POST_Request_Test_01() {
		
		test.log(LogStatus.INFO	, "Test is starting...");
		
		HeaderConfig headerObj = new HeaderConfig();
		POST_API_Payload payloadObj = new POST_API_Payload();
		
		Response response = RestAssured.given()
							.when().headers(headerObj.defaultHeaders())
										.body(payloadObj.POST_Request_Payload(Integer.parseInt(JavaUtilities.generateRandomNumber()), 
												JavaUtilities.generateRandomString(), JavaUtilities.generateRandomString(), Integer.parseInt("4")))
										.post(APIEnpoints.allAPIEndpoints.CREATE_SINGLE_USER);
		
		ResponseVerification.responseKeyValidationFromJsonObject(response, "LastName");
		ResponseVerification.responseCodeValidation(response, 201);
		ResponseVerification.responseTimeValidation(response);
		
		test.log(LogStatus.INFO, "Test is ended...");
	}
}
