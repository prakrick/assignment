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

import io.cucumber.java.en.And;

public class ProductListPage {

	SeleniumWrappers seleniumWrappers;
	WaitHelper waitHelper;
	
	
	public ProductListPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers,WaitHelper waitHelper){
		this.seleniumWrappers = seleniumWrappers;
		this.waitHelper = waitHelper;
	}

	public void clickOnProductWithName(String productDisplayName) {
		String productDisplayNameXpath = "//div[contains(text(), '"+productDisplayName+"')]";
		seleniumWrappers.getElement(By.xpath(productDisplayNameXpath)).click();
	}


}

