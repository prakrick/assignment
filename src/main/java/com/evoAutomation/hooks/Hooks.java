package com.evoAutomation.hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.evoAutomation.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private static Logger logger = LoggerFactory.getLogger(Hooks.class);

	ConfigReader configReader;
	
	public Hooks(ConfigReader configReader) {
		System.out.println("in hooks constructor");
		this.configReader = configReader;
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		logger.info("-------------------Sceanrio Started------------------ ::->"+scenario.getName());
		configReader.readPropertiesFile();
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		logger.info("-------------------Sceanrio Completed------------------ ::->"+scenario.getName());
		
	}
}
