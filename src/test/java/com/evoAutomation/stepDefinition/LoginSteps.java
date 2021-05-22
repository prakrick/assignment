package com.evoAutomation.stepDefinition;

import com.evoAutomation.pages.LoginPage;

import io.cucumber.java.en.Given;

//import io.cucumber.java8.En;


public class LoginSteps{
	LoginPage loginPage;
	
	public LoginSteps(LoginPage loginPage) {
		this.loginPage = loginPage;
	}
		
//		Given("user login", () -> {
//		    loginPage.login();
//		});
//	}

	@Given("^user login$")
	public void login(){
		loginPage.login();
	}
	

}
