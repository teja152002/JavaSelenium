package bdd.webapps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions (features = {"src/test/java/Features/westflorida.feature"}, glue = "bdd.webapps", monochrome = true , plugin = {"pretty", "html:target/westflodira/index.html"}, 
tags = "@smoke")
public class TestRunner_WestFloridaRegister {

}
