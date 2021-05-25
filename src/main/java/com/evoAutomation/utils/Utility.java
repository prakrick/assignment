package com.evoAutomation.utils;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {

	private static Logger logger = LoggerFactory.getLogger(Utility.class);

	private Map<String,List<String>> getEnvironmentMap(){
		String env = ConfigReader.configData.getProperty("executionEnv").toUpperCase();
		if(JsonReader.userDetailsMap.containsKey(env)){
			return JsonReader.userDetailsMap.get(env);
		}else{
			logger.info("Environment value not present in json "+env);
			return null;
		}
	}

	public List<String> getUserLoginDetails(String userType){
		Map<String,List<String>> environmentMap = getEnvironmentMap();
		if(environmentMap!=null && environmentMap.containsKey(userType)){
			return environmentMap.get(userType);
		}else{
			logger.info("User type value not present in json "+userType);
			return null;
		}
	}

}
