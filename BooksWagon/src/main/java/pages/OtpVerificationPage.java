package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OtpVerificationPage {
	WebDriver driver;
	WebDriverWait wait;

	// Locators
	By otpField = By.id("txtOTP"); // Uncomment if OTP input is needed
	By passwordField = By.id("txtPassword");
	By confirmPasswordField = By.id("txtConfirmPassword");
	By signUpButton = By.id("btnSignUp");
	By successMessage = By.xpath("//div[contains(text(),'Account created successfully')]");

	// Constructor
	public OtpVerificationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public boolean isOTPPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("otp-verification"));
		return driver.getCurrentUrl().contains("otp-verification");
	}


	public void enterPassword(String password) {
		WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		WebElement confirmPasswordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField));
		confirmPasswordElement.clear();
		confirmPasswordElement.sendKeys(confirmPassword);
	}

	public void clickSignUp() {
		WebElement signUpBtn = wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
		signUpBtn.click();
	}

	public boolean isAccountCreated() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
	}

}
