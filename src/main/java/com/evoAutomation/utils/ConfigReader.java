package com.evoAutomation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties configData = null;

	public void readPropertiesFile(){
		try {
			FileReader reader = new FileReader("src/test/resources/config.properties");
			configData = new Properties();
			configData.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
