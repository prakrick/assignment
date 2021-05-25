package com.evoAutomation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserLib {

	WebDriver driver = null;

	private static Logger logger = LoggerFactory.getLogger(BrowserLib.class);

	public void setupDriver(){
		String browser = ConfigReader.configData.getProperty("browser").toLowerCase();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			logger.info("Browser implementation is not available for ::->"+browser);
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public WebDriver getDriver(){
		return this.driver;
	}
}
