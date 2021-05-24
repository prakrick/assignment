package com.evoAutomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evoAutomation.utils.*;

public class WaitHelper {

	private final WebDriver driver;
	private WebDriverWait webDriverWait;
	
	public WaitHelper(BrowserLib browserLib) {
		this.driver = browserLib.getDriver();
	}
	
	public Boolean checkForVisibilityOfElement(WebElement element, Integer... timeInSeconds){
		try{
			webDriverWait = getWebDriverWaitForGivenTime(timeInSeconds);
			return webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean checkForVisibilityOfElementByLocator(By locator, Integer... timeInSeconds){
		try{
			webDriverWait = getWebDriverWaitForGivenTime(timeInSeconds);
			return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		}catch(Exception e){
			return false;
		}
	}
	
	public WebElement waitForVisibilityOfElementByLocator(By locator, Integer... timeInSeconds){
		try{
			webDriverWait = getWebDriverWaitForGivenTime(timeInSeconds);
			return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e){
			return null;
		}
	}
	
	public WebElement waitForVisibilityOfElement(WebElement webElement, Integer... timeInSeconds){
		try{
			webDriverWait = getWebDriverWaitForGivenTime(timeInSeconds);
			return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
		}catch(Exception e){
			return null;
		}
	}
	
	public WebElement waitForElementToBeClickable(WebElement webElement, Integer... timeInSeconds){
		try{
			webDriverWait = getWebDriverWaitForGivenTime(timeInSeconds);
			return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
		}catch(Exception e){
			return null;
		}
	}
	
	public WebDriverWait getWebDriverWaitForGivenTime(Integer[] timeInSeconds){
		Integer waitTimeInSeconds = timeInSeconds.length>0 ? timeInSeconds[0] : Integer.parseInt(ConfigReader.configData.getProperty("WAIT_TIME"));
		return new WebDriverWait(this.driver, waitTimeInSeconds); 
	}
}
