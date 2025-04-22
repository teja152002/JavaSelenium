package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions (features = {"src/test/java/calculator.feature"}, glue = "stepdefinition", monochrome = true,
plugin = {
        "pretty", 
        "html:target/cucumber-reports.html", 
        "json:target/cucumber-reports.json", 
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class TestRunner {

}
