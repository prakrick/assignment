package com.evoAutomation.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evoAutomation.utils.BrowserLib;
import com.evoAutomation.utils.ConfigReader;
import com.evoAutomation.utils.SeleniumWrappers;

import io.cucumber.java.en.And;

public class ProductDescriptionPage {

	SeleniumWrappers seleniumWrappers;
	
	private final WebDriver driver;
	private final WebDriverWait wait;
		
	@FindBy(css="#pincodeInputId")
	private WebElement pincodeTxtbox;
	
	@FindBy(css="._2P_LDn")
	private WebElement checkChangePincodeButton;
	
	public ProductDescriptionPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		this.wait = new WebDriverWait(this.driver, 15);
	}

	public Boolean navigateToItemDescriptionWindow(String productDisplayName) {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String handle: handles){
			if (handle!=parentWindow){
				driver.switchTo().window(handle);
			}
		}
		String productDisplayNameXpath = "//span[contains(text(), '"+productDisplayName+"')]";
		return seleniumWrappers.getElement(By.xpath(productDisplayNameXpath)).isDisplayed();
	}

	public void enterProductDeliveryPincode(String pincode) {
		seleniumWrappers.clearAndSendKeys(pincodeTxtbox, pincode);
		checkChangePincodeButton.click();
	}
	
	public void clickAddToCart(){
		
	}
	
}
