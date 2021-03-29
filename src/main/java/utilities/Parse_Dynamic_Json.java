package utilities;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class Parse_Dynamic_Json {
	// How to parse dynamic json? How to parse nested json?
	public static void parseObject(JSONObject json, String key) {
//		System.out.println(json.has(key));
		System.out.println(json.get(key));
	}
	public static void getKey(JSONObject json, String key) {
		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;
		if (!exists) {
			keys = json.keys();
			while(keys.hasNext()) {
				nextKeys = (String)keys.next();
				try {
					if(json.get(nextKeys) instanceof JSONObject) {
						if(exists == false) {
							getKey(json.getJSONObject(nextKeys), key);
						}
					}
					else if(json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for(int i=0; i<jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerjson = new JSONObject(jsonarrayString);
							if(exists == false) {
								getKey(innerjson, key);
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} 
		else {
			parseObject(json, key);
		}
	}
	
	public static void main(String[] args) {
		String input = "{\r\n" + 
				"  \"data\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 1,\r\n" + 
				"      \"Name\": \"Choc Cake\",\r\n" + 
				"      \"Image\": \"1.jpg\",\r\n" + 
				"      \"Category\": \"Meal\",\r\n" + 
				"      \"Method\": \"\",\r\n" + 
				"      \"Ingredients\": [\r\n" + 
				"        {\r\n" + 
				"          \"name\": \"1 Cup Ice\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"name\": \"1 Bag Beans\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"id\": 2,\r\n" + 
				"      \"Name\": \"Ice Cake\",\r\n" + 
				"      \"Image\": \"2.jpg\",\r\n" + 
				"      \"Category\": \"Meal\",\r\n" + 
				"      \"Method\": \"\",\r\n" + 
				"      \"Ingredients\": [\r\n" + 
				"        {\r\n" + 
				"          \"name\": \"1 Cup Ice\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		JSONObject inputJson = new JSONObject(input);
		getKey(inputJson, "name");
	}
}
