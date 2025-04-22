package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExtentReport {

	static ExtentReports extent;
	static ExtentTest test;
	static Properties properties;

	static {
		try {
			// Load properties file
			properties = new Properties();
			FileInputStream fis = new FileInputStream("src/test/java/Config/extent.properties");
			properties.load(fis);

			// Read report path from properties
			String reportPath = properties.getProperty("extent.reporter.spark.out");

			// Setup Extent Reports
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			sparkReporter.loadXMLConfig("src/test/java/Config/extent-config.xml");

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);

			// Adding system info
			extent.setSystemInfo("OS", properties.getProperty("systeminfo.os"));
			extent.setSystemInfo("User", properties.getProperty("systeminfo.user"));
			extent.setSystemInfo("Build", properties.getProperty("systeminfo.build"));
			extent.setSystemInfo("App Name", properties.getProperty("systeminfo.AppName"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		test = extent.createTest("User navigates to login page");
		test.info("User is on the login page");
		System.out.println("User is on the login page");
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		test.info("User enters valid credentials");
		System.out.println("User enters valid username and password");
	}

	@When("Clicks the login button")
	public void clicks_the_login_button() {
		test.info("User clicks the login button");
		System.out.println("User clicks the login button");
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		test.pass("User logged in successfully");
		System.out.println("User logged in successfully");
		//extent.flush();
	}

}
