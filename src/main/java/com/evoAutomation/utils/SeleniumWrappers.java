package com.evoAutomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
	
	public void enterTextUsingJsExecutorById(String id, String textToEnter) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		//set the text
		jsExecutor.executeScript("document.getElementById('"+id+"').value='"+textToEnter+"'");
		System.out.println("sdssds");
	}

	public void clickUsingJsExecutor(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);	
	}

	public void sendKeyboardEvent(WebElement element, Keys key, Integer... numberOfTimes) {
		 int numOfKeyEvents = numberOfTimes.length>=0 ? numberOfTimes[0] : 1;
		 int i =0;
		 do{
			 element.sendKeys(key);
			 i++;
		 }while(i<numOfKeyEvents);
	}
	
	public void selectDropdownByValue(WebElement dropdownElement, String value){
		Select ddlElement = new Select(dropdownElement);
		ddlElement.selectByValue(value);
	}
}
