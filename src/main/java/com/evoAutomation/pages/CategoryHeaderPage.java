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

public class CategoryHeaderPage {

	SeleniumWrappers seleniumWrappers;
	
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public CategoryHeaderPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers){
		System.out.println("inside category page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		this.wait = new WebDriverWait(this.driver, 10);
	}

	public void mouseHoverOnCategory(String categoryName) {
		String categoryHeaderXpath = "//span[contains(text(), '"+categoryName+"')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoryHeaderXpath)));
		seleniumWrappers.moveToElement(By.xpath(categoryHeaderXpath));
	}
	
	public void clicksOnListItem(String listItem) {
	    String categoryListItem = "//a[@title='"+listItem+"']";
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoryListItem)));
	    seleniumWrappers.getElement(By.xpath(categoryListItem)).click();
	    
	}
	
}

