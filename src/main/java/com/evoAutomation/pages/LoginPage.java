package com.evoAutomation.pages;

import org.openqa.selenium.WebDriver;

import com.evoAutomation.utils.BrowserLib;

public class LoginPage {

	private final WebDriver driver;
	
	public LoginPage(BrowserLib browserLib){
		System.out.println("inside login page");
		this.driver = browserLib.getDriver();
	
	}
	
	public void login(){
		driver.get("http://google.co.in/");
	}
}

