package bdd.webapps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WestFloridaRegister {

	WebDriver driver;

	@Given("Open website redirect to register an account")
	public void open_website_redirect_to_register_an_account() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://westfloridaahec.org/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]/a")).click();
	}

	@When("User Enter Username")
	public void user_enter_username() {
		driver.findElement(By.xpath("//input[@id='reg_username']")).sendKeys("Teja");
	}

	@When("User Enter Valid Email")
	public void user_enter_valid_email() {
		driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("teja1234@gmail.com");
	}

	@When("User enter valid password")
	public void user_enter_valid_password() {
		driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("Teja@1234@12");
	}

	@When("User Enter Register Button")
	public void user_enter_register_button() {
		driver.findElement(By.xpath("//button[@name='register']")).click();
	}

	@Then("User is redirected to Dashboard")
	public void user_is_redirected_to_dashboard() {
		System.out.println("User is redirected to Dashboard!");
	}
	
	@Given("Valid Credentials")
	public void valid_credentials() {
	    if (driver == null) { // Ensure driver is initialized
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	    driver.get("https://westfloridaahec.org/my-account/");
	}

	@When("user enter valid username")
	public void user_enter_valid_username() {
	    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Teja");
	}

	@When("enter valid password")
	public void enter_valid_password() {
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Teja@1234@12");
	}

	@When("click on login button")
	public void click_on_login_button() {
	    driver.findElement(By.xpath("//button[@name='login']")).click();
	}

	@Then("user redirected to dashboard")
	public void user_redirected_to_dashboard() {
	    System.out.println("User is redirecting to login page!");
	}

}
