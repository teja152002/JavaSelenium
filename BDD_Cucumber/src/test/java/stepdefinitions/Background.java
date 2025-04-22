package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Background {

	@Given("User in Login page")
	public void user_in_login_page() {
		System.out.println("backgorund->given");
	}

	@When("user enter valid username and password")
	public void user_enter_valid_username_and_password() {
		System.out.println("backgorund -> when");
	}
	
	@When("click on sign in button")
	public void click_on_sign_in_button() {
	   System.out.println("background -> when");
	}

	@Then("user logged in")
	public void user_logged_in() {
		System.out.println("background->then");
	}
	


//	@Given("User is logged in")
//	public void user_is_logged_in() {
//		System.out.println("s1->given");
//	}

	@When("clicks on home page")
	public void clicks_on_home_page() {
		System.out.println("s1->when");
	}

	@When("User clicks on logout button")
	public void user_clicks_on_logout_button() {
		System.out.println("s1->when");
	}

	@Then("user is logged out")
	public void user_is_logged_out() {
		System.out.println("s1->then");
	}

	@When("clicks on profile")
	public void clicks_on_profile() {
		System.out.println("s2->when");
	}

	@When("User is seen logout button")
	public void user_is_seen_logout_button() {
		System.out.println("s2->when");
	}

	@Then("user can logged out button")
	public void user_can_logged_out_button() {
		System.out.println("s2->then");
	}
}
