package studentApiTest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import base.TestBase;
import configuration.APIEnpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_API_Test_01 extends TestBase{
	
	@Test
	public void get_api_test_01() {
		RestAssured.given().when().get(APIEnpoints.allAPIEndpoints.GET_LIST_OF_USERS).then().log().all().statusCode(200);
	}
	
	@Test
	public void get_api_test_02() {
		Response response = RestAssured.given().when().get(APIEnpoints.allAPIEndpoints.GET_LIST_OF_USERS);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getCookies());
		System.out.println(response.getTime());
	}
	
	@Test
	public void get_api_test_03() {
		test.log(LogStatus.INFO, "Test is starting...");
		Response response = RestAssured.given().when().get(APIEnpoints.allAPIEndpoints.GET_LIST_OF_USERS);
		test.log(LogStatus.INFO, response.getBody().asString());
		test.log(LogStatus.INFO, "Status Code: " + response.getStatusCode());
		test.log(LogStatus.INFO, "Execution Time: " + response.getTime());
		
		JSONArray array = new JSONArray(response.getBody().asString());
		for(int i=0; i<array.length(); i++) {
			System.out.println(array.get(i));
			JSONObject obj = array.getJSONObject(i);
			
			test.log(LogStatus.INFO, "Validated values are: " + obj.get("FirstName"));
//			System.out.println(obj.get("id")+"-"+obj.get("FirstName")+"-"+obj.get("LastName")+"-"+obj.get("SubjectID"));
		}
		test.log(LogStatus.INFO, "Test is passed");
		test.log(LogStatus.INFO, "Test is ended...");
	}
}
