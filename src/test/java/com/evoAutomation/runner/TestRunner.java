package com.evoAutomation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun = false,
		features = {"src/test/resources/features/"},
		tags="@regression",
		glue={"com.evoAutomation"},
		plugin = { "pretty", "html:target/cucumber-reports.html" },
		monochrome = true)

public class TestRunner {

}
