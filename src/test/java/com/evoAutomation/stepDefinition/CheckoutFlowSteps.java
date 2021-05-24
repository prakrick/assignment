package com.evoAutomation.stepDefinition;

import org.junit.Assert;

import com.evoAutomation.pages.CartPage;
import com.evoAutomation.pages.HomePage;

import ch.qos.logback.classic.boolex.IEvaluator;

import com.evoAutomation.pages.CheckoutFlowPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CheckoutFlowSteps{
	CheckoutFlowPage checkoutFlowPage;
	
	public CheckoutFlowSteps(CheckoutFlowPage checkoutFlowPage) {
		this.checkoutFlowPage = checkoutFlowPage;
	}
	
	@Given("User logs in as a {string} customer during checkout")
	public void user_login_as_a_customer_during_checkout(String userType) {
		checkoutFlowPage.loginOnCheckoutPage(userType);
	}

	@Then("User verifies item {string} present in order summary")
	public void user_verifies_item_present_in_order_summary(String itemName) {
		Boolean actualData = checkoutFlowPage.verifyItemInOrderSummary(itemName);
		Assert.assertTrue("Item not present in order summary", actualData);
	}
	
	@When("User clicks Continue button on order summary")
	public void user_clicks_continue_button_order_summary() {
		checkoutFlowPage.clickContinueButtonOrderSummary();
	}
	
	@And("User selects net banking as payment option")
	public void user_selects_net_banking_as_payment_option() {
	    checkoutFlowPage.clickOnNetBankingPaymentOption();
	}
	
	@And("User selects {string} from Bank list")
	public void user_selects_from_bank_list(String bankName) {
	    checkoutFlowPage.selectBankFromBankList(bankName);
	}
	
	@When("User clicks on PAY button")
	public void user_clicks_on_pay_button() {
	    checkoutFlowPage.clickPayButton();
	}
	
	
}
