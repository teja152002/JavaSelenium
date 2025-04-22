package stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions (features = "src/test/java/Features/testautomation.feature", glue = {"stepdefinitions"})
public class TestRunnerTestAutomation {

}
