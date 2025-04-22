//package stepdefinitions;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith (Cucumber.class)
//@CucumberOptions (features = "src/test/java/Features/background.feature", glue = "stepdefinitions", 
//plugin = {"pretty",
//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output/" } , monochrome = true
//
//		)
//
////plugin = {"pretty",
////		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
////		"timeline:test-output-thread/"
////
////		
////}
//public class TestRunner_Background {
//
//}

package stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features/background.feature",
    glue = "stepdefinitions",
    plugin = {
        "pretty",
        "html:test-output/CucumberReport.html",
        "json:test-output/CucumberReport.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output/"
    },
    monochrome = true
)
public class TestRunner_Background {
}


