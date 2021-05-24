package com.evoAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.picocontainer.classname.ClassName;

import com.evoAutomation.utils.BrowserLib;
import com.evoAutomation.utils.ConfigReader;
import com.evoAutomation.utils.SeleniumWrappers;
import com.evoAutomation.utils.WaitHelper;

import net.bytebuddy.jar.asm.ClassReader;

public class CartPage {

	SeleniumWrappers seleniumWrappers;
	
	private final WebDriver driver;
	private final WaitHelper waitHelper;
	
	
	@FindBy(className="_1Er18h")
	private WebElement cartProductSection;
	
	@FindBy(css="._2KpZ6l._2ObVJD._3AWRsL")
	private WebElement placeOderBtn;
	
	public CartPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers,WaitHelper waitHelper){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		PageFactory.initElements(driver, this);
		this.waitHelper = waitHelper;
	
	}

	public void clickOnCartIcon() {
		waitHelper.
		wait.until(ExpectedConditions.visibilityOf(cartProductSection));
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

