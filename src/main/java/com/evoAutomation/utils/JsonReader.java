package com.evoAutomation.utils;

import java.io.FileReader;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonReader {
	
	private static Logger logger = LoggerFactory.getLogger(JsonReader.class);
	
	private final String userDetailsPath = "src/test/resources/user_details.json";
	public static Map<String,Map<String,List<String>>> userDetailsMap = new HashMap<>();
	
	public void parseUserDetails(){
		try {
			JsonObject userDetailsObj = (JsonObject)JsonParser.parseReader(new FileReader(userDetailsPath));
			for(String envValue : userDetailsObj.keySet()){
				Map<String,List<String>> userTypeMap = new HashMap<>();
				JsonObject envObject = userDetailsObj.get(envValue).getAsJsonObject();
				for(String userType: envObject.keySet()){
					List<String> userDetailsList = new ArrayList<>();
					JsonObject userObject = envObject.get(userType).getAsJsonObject();
					String userName = userObject.get("username").getAsString();
					String password = userObject.get("password").getAsString();
					userDetailsList.add(userName);
					userDetailsList.add(password);
					userTypeMap.put(userType, userDetailsList);
				}
				userDetailsMap.put(envValue, userTypeMap);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getUserDetails(String userType){
		try {
			String env = ConfigReader.configData.getProperty("executionEnv");
			JsonObject userDetailsObj = (JsonObject)JsonParser.parseReader(new FileReader(userDetailsPath));
			if (userDetailsObj.has(env)){
				JsonObject envObject = userDetailsObj.get(env).getAsJsonObject();
				if(envObject.has(userType)){
					JsonObject userObject = envObject.get(userType).getAsJsonObject();
					String userName = userObject.get("userName").getAsString();
					String password = userObject.get("password").getAsString();
				}
				else{
					logger.warn("User details not available for user type "+userType);
				}
			}
			else{
				logger.warn("User details not available for environment "+env);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
