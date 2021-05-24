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
import com.evoAutomation.utils.WaitHelper;

public class CategoryHeaderPage {

	SeleniumWrappers seleniumWrappers;
	WaitHelper waitHelper;
	
	@FindBy(className="_24OVr")
	private WebElement previousCursor;
	
	public CategoryHeaderPage(SeleniumWrappers seleniumWrappers, WaitHelper waitHelper){
		System.out.println("inside category page");
		this.seleniumWrappers = seleniumWrappers;
		this.waitHelper = waitHelper;
	}

	public void mouseHoverOnCategory(String categoryName) {
		String categoryHeaderXpath = "//span[contains(text(), '"+categoryName+"')]";
		waitHelper.waitForVisibilityOfElement(previousCursor, 10);
		waitHelper.waitForElementToBeClickableByLocator(By.xpath(categoryHeaderXpath),5);
		seleniumWrappers.moveToElement(By.xpath(categoryHeaderXpath));
	}
	
	public void clicksOnListItem(String listItem) {
	    String categoryListItem = "//a[@title='"+listItem+"']";
	    waitHelper.waitForVisibilityOfElementByLocator(By.xpath(categoryListItem)).click(); 
	}
	
}

