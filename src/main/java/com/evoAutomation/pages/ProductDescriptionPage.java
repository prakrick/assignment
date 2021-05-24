package com.evoAutomation.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evoAutomation.utils.BrowserLib;
import com.evoAutomation.utils.ConfigReader;
import com.evoAutomation.utils.SeleniumWrappers;
import com.evoAutomation.utils.WaitHelper;

import io.cucumber.java.en.And;

public class ProductDescriptionPage {

	SeleniumWrappers seleniumWrappers;
	WaitHelper waitHelper;
	
	private final WebDriver driver;
	
	private final String pincodeTextBoxId = "pincodeInputId";
	private final String addToCartButtonXpath = "//*[text()='ADD TO CART']";
	private final String deliverByXpath = "//*[text()='Delivery by']";
	
	@FindBy(id=pincodeTextBoxId)
	private WebElement pincodeTxtbox;
	
	@FindBy(xpath="//*[text()='Check']")
	private WebElement checkChangePincodeButton;
	
	@FindBy(xpath=addToCartButtonXpath)
	private WebElement addToCartButton;
	
	@FindBy(xpath=deliverByXpath)
	private WebElement deliverBy;
	
	public ProductDescriptionPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers,WaitHelper waitHelper){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		PageFactory.initElements(driver, this);
		this.waitHelper = waitHelper;
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
		pincodeTxtbox.click();
		
		seleniumWrappers.sendKeyboardEvent(pincodeTxtbox, Keys.BACK_SPACE, 6);
	
		pincodeTxtbox.sendKeys(pincode,Keys.ENTER);
	}

	public void clickAddToCart(){
		waitHelper.waitForElementToBeClickable(addToCartButton).click();
	}
	
	public boolean verifyDeliveryAvailable(){
		return waitHelper.checkForVisibilityOfElement(deliverBy);
	}
	
}
