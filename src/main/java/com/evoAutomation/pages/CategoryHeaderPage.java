package com.evoAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.evoAutomation.utils.SeleniumWrappers;
import com.evoAutomation.utils.WaitHelper;

public class CategoryHeaderPage {

	SeleniumWrappers seleniumWrappers;
	WaitHelper waitHelper;
	
	@FindBy(className="_24OVr")
	private WebElement previousCursor;
	
	public CategoryHeaderPage(SeleniumWrappers seleniumWrappers, WaitHelper waitHelper){
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

