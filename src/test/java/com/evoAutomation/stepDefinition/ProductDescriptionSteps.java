package com.evoAutomation.stepDefinition;

import org.junit.Assert;

import com.evoAutomation.pages.HomePage;
import com.evoAutomation.pages.OppoMobileStorePage;
import com.evoAutomation.pages.ProductDescriptionPage;
import com.evoAutomation.pages.ProductListPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class ProductDescriptionSteps{
	ProductDescriptionPage productDescriptionPage;
	
	public ProductDescriptionSteps(ProductDescriptionPage productDescriptionPage) {
		this.productDescriptionPage = productDescriptionPage;
	}
	
	@When("User navigates to the item description page of {string}")
	public void user_navigates_to_the_item_description_page_of(String productDisplayName) {
		String failureMsg = "Incorrect Product Name";
		Boolean actualValue = productDescriptionPage.navigateToItemDescriptionWindow(productDisplayName);
		Assert.assertTrue(failureMsg, actualValue);
	}
	
	@And("User enters product delivery pincode {string}")
	public void user_enters_product_delivery_pincode(String pincode) {
	    productDescriptionPage.enterProductDeliveryPincode(pincode);
	}
}
