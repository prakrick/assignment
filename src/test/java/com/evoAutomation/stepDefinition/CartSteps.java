package com.evoAutomation.stepDefinition;

import org.junit.Assert;

import com.evoAutomation.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CartSteps{
	CartPage cartPage;

	public CartSteps(CartPage cartPage) {
		this.cartPage = cartPage;
	}

	@Then("User verifies item {string} exists in cart")
	public void user_verifies_item_exists_in_cart(String productDisplayName) {
		boolean actualData = cartPage.verifyProductInCart(productDisplayName);
		Assert.assertTrue("Product is not available in cart ::->"+productDisplayName, actualData);
	}

	@When("User clicks on Place Order button")
	public void user_clicks_on_place_order_button() {
		cartPage.clickOnPlaceOrderBtn();
	}
}
