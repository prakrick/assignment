package com.evoAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.evoAutomation.utils.BrowserLib;
import com.evoAutomation.utils.SeleniumWrappers;
import com.evoAutomation.utils.Utility;
import com.evoAutomation.utils.WaitHelper;

public class CheckoutFlowPage {

	SeleniumWrappers seleniumWrappers;
	Utility utility;
	
	private final WebDriver driver;
	private final WaitHelper waitHelper;
	
	@FindBy(css="._2IX_2-._17N0em")
	private WebElement emailAddressTxtBox;
	
	@FindBy(css="._2KpZ6l._20xBvF._3AWRsL")
	private WebElement continueBtn;
	
	@FindBy(css="input[type='password']")
	private WebElement passwordTxtBox;
	
	@FindBy(css="button[type='submit']")
	private WebElement loginBtn;
	
	@FindBy(className="McovBK")
	private WebElement ordrCnfrmtnEmailInfo;
	
	@FindBy(id="to-payment")
	private WebElement orderSummaryContinueBtn;
	
	@FindBy(id="#NET_OPTIONS")
	private WebElement netBankingOptnBtn;
	
	@FindBy(xpath="//button[contains(text(), 'PAY')]")
	private WebElement payButton;
	
	public CheckoutFlowPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers, 
			Utility utility,WaitHelper waitHelper){
		System.out.println("inside home page");
		this.driver = browserLib.getDriver();
		this.seleniumWrappers = seleniumWrappers;
		PageFactory.initElements(driver, this);
		this.waitHelper = waitHelper;
		this.utility = utility;
	}
	
	public Boolean verifyItemInOrderSummary(String itemName){
		String productNameOrdrSmryXpath = "//div[contains(text(), '"+itemName+"')]";
		return seleniumWrappers.getElement(By.xpath(productNameOrdrSmryXpath)).isDisplayed();
	}
	
	public void clickContinueButton(){
		waitHelper.waitForElementToBeClickable(continueBtn);
		continueBtn.click();
	}
	
	public void selectPopularBank(String bankName){
		String popularBankNameCSS = "input[id='"+bankName+"']";
		seleniumWrappers.getElement(By.cssSelector(popularBankNameCSS)).click();
	}
	
	public void clickPayButton(){
		waitHelper.waitForElementToBeClickable(payButton);
		payButton.click();
	}

	public void loginOnCheckoutPage(String userType) {
		List<String> userCredentials = utility.getUserLoginDetails(userType);
		emailAddressTxtBox.sendKeys(userCredentials.get(0));
		continueBtn.click();
		passwordTxtBox.sendKeys(userCredentials.get(1));
		loginBtn.click();
		waitHelper.waitForVisibilityOfElement(ordrCnfrmtnEmailInfo);
	}

	public void clickContinueButtonOrderSummary() {
		orderSummaryContinueBtn.click();
		waitHelper.waitForElementToBeClickable(netBankingOptnBtn);
	}

	public void clickOnNetBankingPaymentOption() {
		netBankingOptnBtn.click();
		waitHelper.waitForVisibilityOfElement(payButton);	
	}
}

