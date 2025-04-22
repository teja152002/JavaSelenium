package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/featurefiles",
    glue = "stepdefinitions", 
    monochrome = true, 
    plugin = {
        "pretty", 
        "html:target/cucumber-reports.html", 
        "json:target/cucumber.json", 
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class SignUp_TestRunner {
}
