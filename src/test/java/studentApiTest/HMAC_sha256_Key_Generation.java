package studentApiTest;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class HMAC_sha256_Key_Generation {
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
		
		String secret = "admin";
		String message = "message";
		
		Mac sha256 = Mac.getInstance("HmacSHA256");
		SecretKeySpec s_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
		
		sha256.init(s_key);
		
		String hash = Base64.encodeBase64String(sha256.doFinal(message.getBytes()));
		
		System.out.println("Hash value: " + hash);
	}
}
