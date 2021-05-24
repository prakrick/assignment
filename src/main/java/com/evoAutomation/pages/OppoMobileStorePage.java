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

public class OppoMobileStorePage {

	SeleniumWrappers seleniumWrappers;
	
	private final WebDriver driver;
	
	public OppoMobileStorePage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
	}

	public void clickOnViewAllButtonForMobilesUnder(String range) {
		String mobUnderRangeViewAll = "//h2[contains(text(), '"+range+"')]/../..//a";
		seleniumWrappers.getElement(By.xpath(mobUnderRangeViewAll)).click();
	}


}

