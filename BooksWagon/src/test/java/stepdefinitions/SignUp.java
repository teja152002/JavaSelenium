package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OtpVerificationPage;
import pages.SignUpPage;
import utilities.BaseClass;
import utilities.ExtentReport;

import java.time.Duration;

public class SignUp {
	WebDriver driver = BaseClass.getDriver();
	SignUpPage signUpPage = new SignUpPage(driver);
	OtpVerificationPage otpPage = new OtpVerificationPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Given("User is on the Bookswagon Sign-Up page")
	public void user_is_on_the_bookswagon_sign_up_page() {
		driver.get("https://www.bookswagon.com/");

		// Initialize ExtentTest to avoid NullPointerException
		if (ExtentReport.getTest() == null) {
			ExtentReport.startTest("Sign Up Test");
		}

		try {
			Actions actions = new Actions(driver);
			WebElement myAccount = driver.findElement(By.xpath("//span[@id='ctl00_lblUser']"));
			actions.moveToElement(myAccount).perform();

			WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[contains(text(),'New to Bookswagon?')]")
			));
			signUpButton.click();

			ExtentReport.getTest().log(Status.INFO, "Navigated to Sign-Up page");
		} catch (Exception e) {
			ExtentReport.getTest().log(Status.FAIL, "Failed to navigate to Sign-Up page: " + e.getMessage());
			Assert.fail("Failed to navigate to Sign-Up page.");
		}
	}

	@When("User enters the name {string}")
	public void user_enters_the_name(String name) {
		signUpPage.enterName(name);
	}

	@When("User enters the mobile number {string}")
	public void user_enters_the_mobile_number(String mobile) {
		signUpPage.enterMobileNumber(mobile);
	}

	@When("User selects country code {string}")
	public void user_selects_country_code(String countryCode) {
		signUpPage.selectCountryCode(countryCode);
	}

	@When("User clicks on I am not a robot")
	public void user_clicks_on_I_am_not_a_robot() {
		signUpPage.clickNotARobot();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		signUpPage.clickContinue();
	}

	@Then("User should be redirected to OTP verification page")
	public void user_should_be_redirected_to_otp_verification_page() {
		try {
			wait.until(ExpectedConditions.urlContains("otp-verification"));
			ExtentReport.getTest().log(Status.PASS, "Successfully redirected to OTP verification page");
		} catch (Exception e) {
			ExtentReport.getTest().log(Status.FAIL, "Failed to reach OTP verification page: " + e.getMessage());
			Assert.fail("OTP page not displayed.");
		}
	}

	@Given("User is on the OTP verification page")
	public void user_is_on_the_otp_verification_page() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    try {
	        // Extra wait for page load
	        Thread.sleep(10000);
	        
	        // Debugging: Print current URL
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println("📌 Current URL: " + currentUrl);
	        
	        // Check if page contains expected keyword
	        if (currentUrl.contains("otp-verification")) {
	            System.out.println("OTP Verification page loaded successfully.");
	        } else {
	            System.out.println(" Expected OTP page, but got: " + currentUrl);
	            System.out.println(" Page Source: " + driver.getPageSource());  // Debugging
	            Assert.fail("Failed to reach OTP verification page.");
	        }
	    } catch (Exception e) {
	        System.out.println("❌ Timeout: OTP Verification page did not load.");
	        Assert.fail("Failed to reach OTP verification page.");
	    }
	}


	@When("User enters password {string}")
	public void user_enters_password(String password) {
		otpPage.enterPassword(password);
	}

	@When("User enters confirm password {string}")
	public void user_enters_confirm_password(String confirmPassword) {
		otpPage.enterConfirmPassword(confirmPassword);
	}

	@When("User clicks on Sign up button")
	public void user_clicks_signup() {
		otpPage.clickSignUp();
	}

	@Then("User account should be successfully created")
	public void user_account_should_be_successfully_created() {
		Assert.assertTrue(otpPage.isAccountCreated(), "Account creation failed");
		ExtentReport.getTest().log(Status.PASS, "Account successfully created");
	}
}
