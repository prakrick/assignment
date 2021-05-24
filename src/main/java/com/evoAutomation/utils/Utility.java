package com.evoAutomation.utils;

import java.util.*;

public class Utility {
	
	private Map<String,List<String>> getEnvironmentMap(){
		String env = ConfigReader.configData.getProperty("executionEnv").toUpperCase();
		if(JsonReader.userDetailsMap.containsKey(env)){
			return JsonReader.userDetailsMap.get(env);
		}else{
			return null;
		}
	}
	
	public List<String> getUserLoginDetails(String userType){
		 Map<String,List<String>> environmentMap = getEnvironmentMap();
		if(environmentMap!=null && environmentMap.containsKey(userType)){
			return environmentMap.get(userType);
		}else{
			return null;
		}
	}

}
