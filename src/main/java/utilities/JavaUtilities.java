package utilities;

import java.util.Base64;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import pojos.CredentialsPojo;

public class JavaUtilities {
	// To generate random integer value
	public static String generateRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(999);
		String id = Integer.toString(randomNumber);
		return id;
	}
	
	// To generate random string value
	public static String generateRandomString() {
		String randomString = RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}
	
	// Convert username and password base64 encode
	public static CredentialsPojo base64Encoding(final String username, final String password) {
		String credential = username + ":" + password;
		try {
			credential = Base64.getEncoder().encodeToString(credential.getBytes());
			System.out.println(credential);
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		CredentialsPojo loginCred = new CredentialsPojo();
		loginCred.setCredentials(credential);
		return loginCred;
	}
}
