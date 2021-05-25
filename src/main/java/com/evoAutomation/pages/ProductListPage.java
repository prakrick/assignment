package com.evoAutomation.pages;

import org.openqa.selenium.By;
import com.evoAutomation.utils.BrowserLib;
import com.evoAutomation.utils.SeleniumWrappers;
import com.evoAutomation.utils.WaitHelper;

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

