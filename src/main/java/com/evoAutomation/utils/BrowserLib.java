package com.evoAutomation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserLib {

	WebDriver driver = null;
	
	private static Logger logger = LoggerFactory.getLogger(BrowserLib.class);
	
	public BrowserLib(){
		System.out.println("inside browser");
		this.setupDriver();
	}

	
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
