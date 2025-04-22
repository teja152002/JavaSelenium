package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChangePasswordPage;
import utilities.BaseClass;

public class ChangePassword_SD {
	
	WebDriver driver = BaseClass.getDriver();
	ChangePasswordPage changePassword = new ChangePasswordPage(driver);
	
	@Given("the user is logged in")
	public void the_user_is_logged_in() {
		changePassword.isUserLogged();
	}

	@Given("the user is redirected to the change password page")
	public void the_user_is_redirected_to_the_change_password_page() {
		changePassword.redirectToChangePassword();
	}

	@When("the user enters their old password")
	public void the_user_enters_their_old_password() {
		changePassword.enterOldPassword();
	}

	@When("the user enters a new password")
	public void the_user_enters_a_new_password() {
		changePassword.enterNewPassword();
	}

	@When("the user enters the new password again in the confirm password field")
	public void the_user_enters_the_new_password_again_in_the_confirm_password_field() {
		changePassword.enterNewConfirmPassword();
	}

	@Then("the password is updated successfully")
	public void the_password_is_updated_successfully() {
		changePassword.clickOnChangePassword();
	}

	@Then("the user receives a confirmation message")
	public void the_user_receives_a_confirmation_message() {
		changePassword.changePasswordConfirmationMessage();
	}

}
