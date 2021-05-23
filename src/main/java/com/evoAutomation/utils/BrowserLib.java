package com.evoAutomation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.evoAutomation.hooks.Hooks;

import io.cucumber.plugin.ConcurrentEventListener;

public class BrowserLib {

	WebDriver driver = null;
//	Properties configData = null;
	
	private static Logger logger = LoggerFactory.getLogger(Hooks.class);
	
	public BrowserLib(){
		System.out.println("inside browser");
		this.setupDriver();
	}
	
//	public void readPropertiesFile(){
//		try {
//			FileReader reader = new FileReader("src/test/resources/config.properties");
//			this.configData = new Properties();
//			this.configData.load(reader);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void setupDriver(){
		System.out.println(ConfigReader.configData);
		String browser = ConfigReader.configData.getProperty("browser").toLowerCase();
		System.out.println(browser);
		switch (browser) {
		case "chrome":
			System.out.println("In case block");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			logger.info("Browser implement not available for ::->"+browser);
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}
}
