package com.evoAutomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.evoAutomation.hooks.Hooks;


public class SeleniumWrappers {

	private static Logger logger = LoggerFactory.getLogger(Hooks.class);
	
	private final WebDriver driver;
	
	public SeleniumWrappers(BrowserLib browserLib){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
	
	}
	
	
	public WebElement getElement(By by)
	{
		WebElement element = null;
		try{
			element = driver.findElement(by);
			logger.debug("Found Element " + element.toString());
			}
		catch(Exception e){
			logger.info("Could not find element ::=>"+by);
			e.printStackTrace();
		}
		return element;
	}
	
	public void moveToElement(By by){
		WebElement el = getElement(by);
		Actions hover = new Actions(driver);
		hover.moveToElement(el).click().build().perform();
	}


	public void clearAndSendKeys(WebElement element, String textToEnter) {
		element.clear();
		element.sendKeys(textToEnter);
		
	}
}
