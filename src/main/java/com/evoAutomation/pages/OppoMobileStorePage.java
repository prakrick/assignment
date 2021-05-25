package com.evoAutomation.pages;

import org.openqa.selenium.By;
import com.evoAutomation.utils.SeleniumWrappers;

public class OppoMobileStorePage {

	SeleniumWrappers seleniumWrappers;


	public OppoMobileStorePage(SeleniumWrappers seleniumWrappers){
		this.seleniumWrappers = seleniumWrappers;
	}

	public void clickOnViewAllButtonForMobilesUnder(String range) {
		String mobUnderRangeViewAll = "//h2[contains(text(), '"+range+"')]/../..//a";
		seleniumWrappers.getElement(By.xpath(mobUnderRangeViewAll)).click();
	}
}

