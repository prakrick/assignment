package com.evoAutomation.pages;

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

public class HomePage {

	SeleniumWrappers seleniumWrappers;
	
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	//static locator strings
	private final String closeLoginModalCSS = "._2KpZ6l._2doB4z";
	
	@FindBy(css = closeLoginModalCSS)
	private WebElement closeLoginModal;
	
	public HomePage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 15);
	}
	
	public void navigateToBaseURL(){
		driver.get(ConfigReader.configData.getProperty("baseURL"));
	}

	public void closeLoginModal() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(closeLoginModalCSS)));
		closeLoginModal.click();
	}
	
	public void clickOnCategory(String categoryName) {
		String categoryXpath = "//div[contains(text(), '"+categoryName+"')]";
		seleniumWrappers.getElement(By.xpath(categoryXpath)).click();
	}
}

