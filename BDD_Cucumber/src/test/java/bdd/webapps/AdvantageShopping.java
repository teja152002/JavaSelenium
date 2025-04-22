package bdd.webapps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdvantageShopping {
	
	WebDriver driver;

	@Given("I am on the Advantage Shopping website registration page")
	public void i_am_on_the_advantage_shopping_website_registration_page() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://advantageonlineshopping.com/#/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id=\"menuUser\"]")).click();
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")).click();
	}

	@When("I enter my account details")
	public void i_enter_my_account_details() {
		driver.findElement(By.xpath("//input[@name='usernameRegisterPage']")).sendKeys("TejaRao");
		driver.findElement(By.xpath("//input[@name='emailRegisterPage']")).sendKeys("teja1234@gmail.com");
		driver.findElement(By.xpath("//input[@name='passwordRegisterPage']")).sendKeys("Teja@1234");
		driver.findElement(By.xpath("//input[@name='confirm_passwordRegisterPage']")).sendKeys("Teja@1234");
	}

	@When("I provide my personal information")
	public void i_provide_my_personal_information() {
		driver.findElement(By.xpath("//input[@name='first_nameRegisterPage']")).sendKeys("Teja");
		driver.findElement(By.xpath("//input[@name='last_nameRegisterPage']")).sendKeys("Rao");
		driver.findElement(By.xpath("//input[@name='phone_numberRegisterPage']")).sendKeys("8688458917");
	}

	@When("I enter my address details")
	public void i_enter_my_address_details() {
		WebElement country =  driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[3]/div[1]/sec-view[1]/div/select"));
		Select sCountry = new Select(country);
		sCountry.selectByContainsVisibleText("India");
		
		driver.findElement(By.xpath("//input[@name='cityRegisterPage']")).sendKeys("Gudur");
		
		driver.findElement(By.xpath("//input[@name='addressRegisterPage']")).sendKeys("9/180, Raja St");
		driver.findElement(By.xpath("//input[@name='state_/_province_/_regionRegisterPage']")).sendKeys("AP");
		driver.findElement(By.xpath("//input[@name='postal_codeRegisterPage']")).sendKeys("518466");
	}

	@When("I submit the registration form")
	public void i_submit_the_registration_form() {
		driver.findElement(By.xpath("//input[@name='i_agree']")).click();
		driver.findElement(By.xpath("//button[@id='register_btn']")).click();
	}

	@Then("my account should be created successfully")
	public void my_account_should_be_created_successfully() {
		System.out.println("Acconut Created Successfull");
	}
	

}
