package configuration;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfig {
	
	public Map<String, String> defaultHeaders() {
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		return defaultHeaders;
	}
	
	public Map<String, String> headersWithToken(){
		Map<String, String> headersWithToken = new HashMap<String, String>();
		headersWithToken.put("Content-Type", "application/json");
		headersWithToken.put("Access_Token", "zxcvbnmlkjhgfdsaqwertyuiop");
		headersWithToken.put("jwt_token", "poiuytrewqasdfghjklmnbvcxz");
		headersWithToken.put("Tenent_Key", "test");
		return headersWithToken;
	}

}
