package com.evoAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evoAutomation.utils.BrowserLib;
import com.evoAutomation.utils.ConfigReader;
import com.evoAutomation.utils.SeleniumWrappers;
import com.evoAutomation.utils.WaitHelper;

public class HomePage {

	SeleniumWrappers seleniumWrappers;
	
	private final WebDriver driver;
	private final WaitHelper waitHelper;
	
	//static locator strings
	private final String closeLoginModalCSS = "._2KpZ6l._2doB4z";
	
	@FindBy(css = closeLoginModalCSS)
	private WebElement closeLoginModal;
	
	@FindBy(className="_3qX0zy")
	private WebElement flipkartHomeIcon;
	
	@FindBy(className="_37M3Pb")
	private WebElement headerSection;
	
	@FindBy(className="YUhWwv")
	private WebElement cartIcon;
	
	@FindBy(className="_1Er18h")
	private WebElement cartProductSection;
	
	public HomePage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers,WaitHelper waitHelper){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		PageFactory.initElements(driver, this);
		this.waitHelper = waitHelper;
	}
	
	public void navigateToBaseURL(){
		driver.get(ConfigReader.configData.getProperty("baseURL"));
	}

	public void closeLoginModal() {
		waitHelper.waitForVisibilityOfElementByLocator(By.cssSelector(closeLoginModalCSS));
		closeLoginModal.click();
	}
	
	public void clickOnCategory(String categoryName) {
		String categoryXpath = "//div[contains(text(), '"+categoryName+"')]";
		seleniumWrappers.getElement(By.xpath(categoryXpath)).click();
	}

	public void clickFlipkartHomeIcon() {
		flipkartHomeIcon.click();
		waitHelper.waitForVisibilityOfElement(headerSection);
	}

	public void clickOnCart() {
		cartIcon.click();
		waitHelper.waitForVisibilityOfElement(cartProductSection);
	}
}

