package studentApiTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import base.TestBase;
import configuration.APIEnpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import validation.ResponseVerification;

public class GET_API_Test_02 extends TestBase{
	
	@Test
	public void GET_Request_Test_01() {
		test.log(LogStatus.INFO, "Test is starting...");
		Response response = RestAssured.given().when().get(APIEnpoints.allAPIEndpoints.GET_LIST_OF_USERS);
		
		ResponseVerification.responseCodeValidation(response, 200);
		ResponseVerification.responseTimeValidation(response);
		ResponseVerification.responseKeyValidationFromArray(response, "FirstName");
//		ResponseVerification.responseKeyValidation(response, "abcdefdjkll");
//		ResponseVerification.responseKeyValidation(response, "SubjectID");
		test.log(LogStatus.INFO, "Test is ended...");
	}
}
