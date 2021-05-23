package com.evoAutomation.stepDefinition;

import com.evoAutomation.pages.HomePage;
import com.evoAutomation.pages.OppoMobileStorePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class OppoMobileStoreSteps{
	OppoMobileStorePage oppoMobileStorePage;
	
	public OppoMobileStoreSteps(OppoMobileStorePage oppoMobileStorePage) {
		this.oppoMobileStorePage = oppoMobileStorePage;
	}
	
	@And("User clicks on View All button for mobiles under {string}")
	public void user_clicks_on_view_all_button_for_mobiles_under(String range) {
	    oppoMobileStorePage.clickOnViewAllButtonForMobilesUnder(range);
	}

}
