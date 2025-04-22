package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestAutomation {

	WebDriver driver;

	@Given("Opening the browser")
	public void opening_the_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@When("Enter Name")
	public void enter_name() {
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Teja");
	}

	@When("Enter Email")
	public void enter_email() {
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("teja1@gmail.com");
	}

	@When("Enter Phone Number")
	public void enter_phone_number() {
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("1236547896");
	}

	@Then("Close the browser")
	public void close_the_browser() {
		if (driver != null) {
			driver.quit();
		}
		System.out.println("Closing the browser!");
	}

}
