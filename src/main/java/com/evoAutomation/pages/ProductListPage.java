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

import io.cucumber.java.en.And;

public class ProductListPage {

	SeleniumWrappers seleniumWrappers;
	
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public ProductListPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		this.wait = new WebDriverWait(this.driver, 15);
	}

	public void clickOnProductWithName(String productDisplayName) {
		String productDisplayNameXpath = "//div[contains(text(), '"+productDisplayName+"')]";
		seleniumWrappers.getElement(By.xpath(productDisplayNameXpath)).click();
	}


}

