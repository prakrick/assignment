package com.evoAutomation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLib {

	WebDriver driver = null;
	
	public BrowserLib(){
		System.out.println("inside browser");
		this.setupDriver();
	}
	
	public void setupDriver(){
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}
}
