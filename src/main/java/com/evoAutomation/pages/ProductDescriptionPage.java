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

import io.cucumber.java.en.And;

public class ProductDescriptionPage {

	SeleniumWrappers seleniumWrappers;
	
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	private final String pincodeTextBoxId = "pincodeInputId";
	private final String addToCartButtonXpath = "//*[text()='ADD TO CART']";
	private final String deliverByXpath = "//*[text()='Delivery by']";
		
	@FindBy(id=pincodeTextBoxId)
	private WebElement pincodeTxtbox;
	
//	@FindBy(className="_2P_LDn")
	@FindBy(xpath="//*[text()='Check']")
	private WebElement checkChangePincodeButton;
	
	@FindBy(xpath=addToCartButtonXpath)
	private WebElement addToCartButton;
	
	@FindBy(xpath=deliverByXpath)
	private WebElement deliverBy;
	
	public ProductDescriptionPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		PageFactory.initElements(driver, this);
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

	public void enterProductDeliveryPincode1(String pincode) {
		try{
			Thread.sleep(10000);
//		seleniumWrappers.clickUsingJsExecutor(checkChangePincodeButton);
		pincodeTxtbox.click();
		Thread.sleep(5000);
//		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
//		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
//		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
//		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
//		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
//		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
		
		Actions a= new Actions(driver);
		a.keyDown(pincodeTxtbox, Keys.CONTROL).sendKeys(String.valueOf('\u0061')).sendKeys(Keys.BACK_SPACE).release().build().perform();
//		pincodeTxtbox.clear();
//		Thread.sleep(5000);
		pincodeTxtbox.click();
		Thread.sleep(5000);
		pincodeTxtbox.sendKeys(pincode,Keys.ENTER);
//		seleniumWrappers.clearAndSendKeys(pincodeTxtbox, pincode);
		seleniumWrappers.enterTextUsingJsExecutorById(pincodeTextBoxId, pincode);
//		wait.until(ExpectedConditions.elementToBeClickable(checkChangePincodeButton));
		Thread.sleep(5000);
		pincodeTxtbox.click();
		Thread.sleep(5000);
		pincodeTxtbox.click();
		pincodeTxtbox.clear();
		seleniumWrappers.enterTextUsingJsExecutorById(pincodeTextBoxId, pincode);
//		checkChangePincodeButton.click();
//		checkChangePincodeButton.click();
//		seleniumWrappers.clickUsingJsExecutor(checkChangePincodeButton);
//		pincodeTxtbox.sendKeys(Keys.ENTER);
//		a.keyDown(pincodeTxtbox,Keys.ENTER).build().perform();
		System.out.println("128458888h7sdsa3s767qwerty");
		}
		catch(Exception e){
			
		}
	}
	
	public void enterProductDeliveryPincode(String pincode) {
		pincodeTxtbox.click();
		
		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
		pincodeTxtbox.sendKeys(Keys.BACK_SPACE);
	
		pincodeTxtbox.sendKeys(pincode,Keys.ENTER);
	}
	

	public void clickAddToCart(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addToCartButtonXpath)));
		addToCartButton.click();
	}
	
	public boolean verifyDeliveryAvailable(){
		wait.until(ExpectedConditions.visibilityOf(deliverBy));
		return deliverBy.isDisplayed();
	}
	
}
