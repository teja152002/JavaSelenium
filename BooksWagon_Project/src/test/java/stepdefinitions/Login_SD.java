package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SignupPage;
import utilities.BaseClass;

public class Login_SD {

	WebDriver driver = BaseClass.getDriver();
	LoginPage login = new LoginPage(driver);

	@Given("User is on the Bookswagon Log in page")
	public void user_is_on_the_bookswagon_log_in_page() {
		if (!SignupPage.isLoggedIn) {
			login.userOnLoginPage();
		}
	}

	@When("User enters the number")
	public void user_enters_the_number() {
		if (!SignupPage.isLoggedIn) {
			login.enterNumber();
		}
	}

	@When("User enters the password")
	public void user_enters_password() {
		if (!SignupPage.isLoggedIn) {
			login.enterPassword();
		}
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		if (!SignupPage.isLoggedIn) {
			login.clickOnLogin();
		}
	}

	@Then("User should be redirected to Bookswagon Account")
	public void user_should_be_redirected_to_bookswagon_account() {
		if (!SignupPage.isLoggedIn) {
			login.bookswagonAccount();
		}
	}

}
