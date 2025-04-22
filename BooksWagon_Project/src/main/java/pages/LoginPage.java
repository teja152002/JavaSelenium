package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver = null;
	WebDriverWait wait = null;
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Locators
	By numberFeild = By.id("ctl00_phBody_SignIn_txtEmail");
	By passwordFeild = By.id("ctl00_phBody_SignIn_txtPassword");
	By clickOnLogin = By.id("ctl00_phBody_SignIn_btnLogin");
	By successMessage = By.id("privacypolicy");
	
	//Methods
	public void userOnLoginPage() {
		Actions actions = new Actions(driver);
		WebElement myAccount =  driver.findElement(By.xpath("//span[@id='ctl00_lblUser']"));
		actions.moveToElement(myAccount).perform();

		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Log in')]")));
		loginButton.click();
	}
	
	public void enterNumber() {
		driver.findElement(numberFeild).sendKeys("9391222487");
	}
	
	public void enterPassword() {
		driver.findElement(passwordFeild).sendKeys("Teja@1234"); // TejaRao@9876 - Teja@1234
	}

	public void clickOnLogin() {
		driver.findElement(clickOnLogin).click();
	}

	public boolean bookswagonAccount() {
		String expected = driver.findElement(successMessage).getText();
		String original = "My Account";	
		if(original.equals(expected)) {
			System.out.println("User succefully logged into Bookswagon Account !");
			return true;
		}else {
			return false;
		}
	}
}
