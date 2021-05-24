package com.evoAutomation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/"},
		tags="@test",
		glue={"com.evoAutomation"},
		plugin = { "pretty", "html:target/cucumber-reports" },
		monochrome = true)

public class TestRunner {

}
