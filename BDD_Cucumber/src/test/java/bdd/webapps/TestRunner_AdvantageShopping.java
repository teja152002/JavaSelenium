package bdd.webapps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions (features =  {"src/test/java/Features/advantageshopping.feature"}, glue = "bdd.webapps", monochrome = true ,
plugin = {"pretty", "html:target/adindex.html","json:target/adindex.json", "junit:target/index.xml "}  )
public class TestRunner_AdvantageShopping {

}
