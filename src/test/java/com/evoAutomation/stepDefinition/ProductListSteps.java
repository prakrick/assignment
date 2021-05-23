package com.evoAutomation.stepDefinition;

import com.evoAutomation.pages.HomePage;
import com.evoAutomation.pages.OppoMobileStorePage;
import com.evoAutomation.pages.ProductListPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class ProductListSteps{
	ProductListPage productListPage;
	
	public ProductListSteps(ProductListPage productListPage) {
		this.productListPage = productListPage;
	}
	
	@When("User clicks on item {string}")
	public void user_clicks_on_item(String productDisplayName) {
		productListPage.clickOnProductWithName(productDisplayName);
	}

}
