package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAndEnv {

	public static Map<String, String> map = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> envAndFile(){
		String environment = System.getProperty("env");
		try {
			if(environment.equalsIgnoreCase("dev")) {
				FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir") + "/inputs/dev.properties");
				propMain.load(fisDev);
				map.put("Server URL", propMain.getProperty("ServerUrl"));
				map.put("Port Number", propMain.getProperty("portNo"));
				map.put("User Name", propMain.getProperty("username"));
				map.put("Password", propMain.getProperty("password"));
			}
			else if(environment.equalsIgnoreCase("qa")) {
				FileInputStream fisQa = new FileInputStream(System.getProperty("user.dir") + "/inputs/qa.properties");
				propMain.load(fisQa);
				map.put("Server URL", propMain.getProperty("ServerUrl"));
				map.put("Port Number", propMain.getProperty("portNo"));
				map.put("User Name", propMain.getProperty("username"));
				map.put("Password", propMain.getProperty("password"));
			}
			else if(environment.equalsIgnoreCase("staging")) {
				FileInputStream fisStaging = new FileInputStream(System.setProperty("user.dir", "/inputs/staging.properties"));
				propMain.load(fisStaging);
				map.put("Server URL", propMain.getProperty("ServerUrl"));
				map.put("Port Number", propMain.getProperty("portNo"));
				map.put("User Name", propMain.getProperty("username"));
				map.put("Password", propMain.getProperty("password"));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
//	public static Map<String, String> getConfigReader(){
//		if(map == null) {
//			map = envAndFile();
//		}
//		return map;
//	}
}
