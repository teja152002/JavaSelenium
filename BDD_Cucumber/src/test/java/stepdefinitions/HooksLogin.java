//package stepdefinitions;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeStep;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class HooksLogin {
//
//	@Before
//	public void before() {
//		System.out.println("Opening browser -> before");
//	}
//	
//	@BeforeStep
//	public void beforeStep() {
//		System.out.println("before step");
//	}
//	@AfterStep
//	public void afterStep() {
//		System.out.println("after step");
//	}
//	
//
//	@Given("User is on login page")
//	public void user_is_on_login_page() {
//		System.out.println("User is on login page->given");
//
//	}
//
//	@When("User enter valid email and password")
//	public void user_enter_valid_email_and_password() {
//		System.out.println("user enter valid email and password -> when");
//	}
//
//	@Then("click on sign in button")
//	public void click_on_sign_in_button() {
//		System.out.println("click on sign in button -> then");
//	}
//
//	@Then("user is logged into website")
//	public void user_is_logged_into_website() {
//		System.out.println("user is logged in -> then");
//	}
//
//	@After
//	public void after() {
//		System.out.println("closing the browser -> after");
//	}
//
//}
