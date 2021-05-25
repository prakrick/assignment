package com.evoAutomation.stepDefinition;

import com.evoAutomation.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class HomePageSteps{
	HomePage homePage;

	public HomePageSteps(HomePage homePage) {
		this.homePage = homePage;
	}

	@Given("User is on homepage")
	public void navigate_To_HomePage(){
		this.homePage.navigateToBaseURL();
	}

	@And("User closes the login modal")
	public void close_Login_Modal(){
		this.homePage.closeLoginModal();
	}

	@Given("User clicks on category {string}")
	public void user_clicks_on_category(String categoryName) {
		this.homePage.clickOnCategory(categoryName);
	}

	@And("User clicks on Flipkart home icon")
	public void user_clicks_on_flipkart_home_icon() {
		homePage.clickFlipkartHomeIcon();
	}

	@And("User clicks on Cart")
	public void user_clicks_on_cart() {
		homePage.clickOnCart();
	}

}
