package com.evoAutomation.stepDefinition;

import com.evoAutomation.pages.CategoryHeaderPage;

import io.cucumber.java.en.Given;

//import io.cucumber.java8.En;


public class CategoryHeaderSteps{
	CategoryHeaderPage categoryHeaderPage;
	
	public CategoryHeaderSteps(CategoryHeaderPage categoryHeaderPage) {
		this.categoryHeaderPage = categoryHeaderPage;
	}
	
	@Given("User mouse hovers on section {string}")
	public void user_mouse_hovers_on_section(String categoryName) {
	   categoryHeaderPage.mouseHoverOnCategory(categoryName);
	}
	
	@Given("User clicks on list item {string}")
	public void user_clicks_on_list_item(String listItem) {
	   categoryHeaderPage.clicksOnListItem(listItem);
	}

}
