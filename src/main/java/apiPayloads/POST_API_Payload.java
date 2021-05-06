package apiPayloads;

import java.util.HashMap;
import java.util.Map;

public class POST_API_Payload {
	
	public Map<String, Object> post_request_payload(int id, String FirstName, String LastName, int SubjectID){
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("id", id);
		payload.put("FirstName", FirstName);
		payload.put("LastName", LastName);
		payload.put("SubjectID", SubjectID);
		
		return payload;
	}
}
