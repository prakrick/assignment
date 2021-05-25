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
	WaitHelper waitHelper;

	private final WebDriver driver;

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

	@FindBy(xpath="//label[@for='NET_OPTIONS']")
	private WebElement netBankingOptnBtn;

	@FindBy(xpath="//button[contains(text(), 'PAY')]")
	private WebElement payButton;

	@FindBy(xpath="//select[@class='_1kwp-i']")
	private WebElement bankListDDL;

	@FindBy(css="input[title='Login']")
	private WebElement netBankingloginButton;

	public CheckoutFlowPage(BrowserLib browserLib, SeleniumWrappers seleniumWrappers, 
			Utility utility,WaitHelper waitHelper){
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
		String popularBankNameXpath = "//label[@for='"+bankName+"']";
		seleniumWrappers.clickUsingJsExecutor(seleniumWrappers.getElement(By.xpath(popularBankNameXpath)));
	}

	public void clickPayButton(){
		waitHelper.waitForElementToBeClickable(payButton);
		payButton.click();
		waitHelper.waitForVisibilityOfElement(netBankingloginButton, 10);
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
	}

	public void clickOnNetBankingPaymentOption() {
		waitHelper.waitForElementToBeClickable(netBankingOptnBtn, 15);
		seleniumWrappers.clickUsingJsExecutor(netBankingOptnBtn);
		waitHelper.waitForVisibilityOfElement(payButton);	
	}

	public void selectBankFromBankList(String bankName) {
		seleniumWrappers.selectDropdownByValue(bankListDDL, bankName);
	}
}

