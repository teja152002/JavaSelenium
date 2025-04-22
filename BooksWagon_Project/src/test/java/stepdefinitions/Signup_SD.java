package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;
import utilities.BaseClass;

public class Signup_SD {
	WebDriver driver = BaseClass.getDriver();
	SignupPage signUp = new SignupPage(driver);

	@Given("User is on the Bookswagon Sign-Up page")
	public void user_is_on_the_bookswagon_sign_up_page() {
		driver.get("https://www.bookswagon.com/");
		signUp.userOnSignUpPage();
	}

	@When("User enters the name")
	public void user_enters_the_name() {
		signUp.enterName();
	}

	@When("User selects country code")
	public void user_selects_country_code() {
		signUp.countryCode();
	}

	@When("User enters the mobile number")
	public void user_enters_the_mobile_number() {
		signUp.enterMobile();
	}

	@When("User clicks on I am not a robot")
	public void user_clicks_on_i_am_not_a_robot() {
		signUp.iamNotRobot();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		signUp.clickContinue();
	}

	@Then("User should be redirected to OTP verification page")
	public void user_should_be_redirected_to_otp_verification_page() {
		if (!signUp.isRegistered) {
			signUp.redirectToOtpPage();
		}
	}

	@Given("User is on the OTP verification page")
	public void user_is_on_the_otp_verification_page() {
		if (!signUp.isRegistered) {
			signUp.otpVerification();
		}
	}

	@When("User enters password")
	public void user_enters_password() {
		if (!signUp.isRegistered) {
			signUp.enterPassword();
		}
	}

	@When("User enters confirm password")
	public void user_enters_confirm_password() {
		if (!signUp.isRegistered) {
			signUp.confirmPassword();
		}

	}

	@When("User clicks on Sign up button")
	public void user_clicks_on_sign_up_button() {
		if (!signUp.isRegistered) {
			signUp.clickOnSignUp();
		}
	}

	@Then("User account should be successfully created")
	public void user_account_should_be_successfully_created() {
		if (!signUp.isRegistered) {
			signUp.accountCreated();
		}
	}
}
