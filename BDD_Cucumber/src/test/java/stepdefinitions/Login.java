package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver;
	
	@Given("valid username and password")
	public void valid_username_and_password() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}

	@When("Enter username")
	public void enter_username() {
		driver.findElement(By.xpath("//*[@id=\"login1\"]"));
	}

	@When("Enter the password")
	public void enter_the_password() {
		driver.findElement(By.xpath("//*[@id=\"password\"]"));
	}

	@When("Click the submit button")
	public void click_the_submit_button() {
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]"));
	}

	@Then("Opens the inbox page")
	public void opens_the_inbox_page() {
		System.out.println("Opens the inbox");
	}
}
