package com.evoAutomation.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.evoAutomation.utils.BrowserLib;
import com.evoAutomation.utils.ConfigReader;
import com.evoAutomation.utils.JsonReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private static Logger logger = LoggerFactory.getLogger(Hooks.class);

	ConfigReader configReader;
	JsonReader jsonReader;
	BrowserLib browserLib;
	WebDriver driver;
	
	public Hooks(ConfigReader configReader,JsonReader jsonReader,BrowserLib browserLib) {
		System.out.println("in hooks constructor");
		this.configReader = configReader;
		this.jsonReader = jsonReader;
		this.browserLib = browserLib;
		}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		logger.info("-------------------Sceanrio Started------------------ ::->"+scenario.getName());
		configReader.readPropertiesFile();
		jsonReader.parseUserDetails();
		browserLib.setupDriver();
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		logger.info("-------------------Sceanrio Completed------------------ ::->"+scenario.getName());
		driver = browserLib.getDriver();
		scenario.attach(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
	    driver.close();
	    driver.quit();
	}
}
