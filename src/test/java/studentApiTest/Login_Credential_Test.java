package studentApiTest;

import org.testng.annotations.Test;

import pojos.CredentialsPojo;
import utilities.JavaUtilities;

public class Login_Credential_Test {
	
	@Test
	public void login_credentials_test() {
		CredentialsPojo loginCred = JavaUtilities.base64Encoding("admin", "admin123");
		System.out.println(loginCred);
	}
}
