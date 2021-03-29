package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import io.restassured.RestAssured;
import utilities.ExtentReportListner;
import utilities.FileAndEnv;

@Listeners(ExtentReportListner.class)
public class TestBase extends ExtentReportListner{
	
	@BeforeClass
	public void baseUrl() {
		System.out.println("Properties data: " + FileAndEnv.envAndFile().get("Server URL"));
		RestAssured.baseURI = FileAndEnv.envAndFile().get("Server URL");
	}
}
