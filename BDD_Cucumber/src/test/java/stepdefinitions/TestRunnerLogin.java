package stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/login.feature", glue = { "stepdefinitions" } , monochrome = true
, plugin = {"pretty", "junit:target/index.xml",
		"json:target/index.json", "html:target/index.html"},
tags = "@smoke")
public class TestRunnerLogin {

}



/*
 * Hooks are block of code that runs before or after each scenario
 * 
 * -> Hooks can be used as iListener that is used in TestNG
 * 
 * -> There are two type of Hooks. 
 * -> 1) Scenario Hooks -> It runs before and after each scenario. 
 * -> 2) Step Hooks -> It runs before and after each steps
 * 
 * Whenever there is a situation of multiple scenarios and like before and after, then we can make use of Hooks.
 */