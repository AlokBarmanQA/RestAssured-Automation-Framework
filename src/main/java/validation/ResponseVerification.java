package validation;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utilities.ExtentReportListner;

public class ResponseVerification extends ExtentReportListner{

	public static void responseCodeValidation(Response response, int statusCode) {
		try {
			Assert.assertEquals(response.getStatusCode(), statusCode);
			test.log(LogStatus.PASS, "Status code validate. Status Code is" + response.getStatusCode());
		}
		catch(AssertionError a) {
			test.log(LogStatus.INFO, a.fillInStackTrace());
			test.log(LogStatus.FAIL, "Expected Status Code:: " + statusCode + "Received Status Code:: " + response.getStatusCode());
		}
		catch(Exception e) {
			test.log(LogStatus.INFO, e.fillInStackTrace());
		}
	}

	public static void responseKeyValidationFromArray(Response response, String key) {
		try {
			JSONArray array = new JSONArray(response.getBody().asString());
			for(int i=0; i<array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
				test.log(LogStatus.PASS, "Validate Value: " + object.get(key));
			}
		} 
		catch (Exception e) {
			e.fillInStackTrace();
		}
	}

	public static void responseKeyValidationFromJsonObject(Response response, String key) {
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			if(json.has(key) && json.get(key) != null) {
				test.log(LogStatus.PASS, "Validate value of: " + key + " is " + json.get(key));
			}
			else {
				test.log(LogStatus.FAIL, "Key is not available");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	public static void responseTimeValidation(Response response) {
		try {
			long time = response.time();
			test.log(LogStatus.INFO, "Response Time:  " + time);
		} 
		catch (Exception e) {
			test.log(LogStatus.INFO, "Response time is not available");
		}
	}
}
