package com.evoAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.evoAutomation.utils.BrowserLib;
import com.evoAutomation.utils.SeleniumWrappers;

public class CartPage {

	SeleniumWrappers seleniumWrappers;

	private final WebDriver driver;	

	@FindBy(className="_1Er18h")
	private WebElement cartProductSection;

	@FindBy(css="._2KpZ6l._2ObVJD._3AWRsL")
	private WebElement placeOderBtn;

	public CartPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers){
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyProductInCart(String productDisplayName) {
		String productNameOnCart = "//a[contains(text(), '"+productDisplayName+"')]";
		return seleniumWrappers.getElement(By.xpath(productNameOnCart)).isDisplayed();

	}

	public void clickOnPlaceOrderBtn() {
		placeOderBtn.click();
		driver.getCurrentUrl().contains("checkout");
	}
}

