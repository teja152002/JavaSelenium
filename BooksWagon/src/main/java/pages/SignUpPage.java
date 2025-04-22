package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	WebDriver driver;
	WebDriverWait wait;

	// Locators
	By nameField = By.id("ctl00_phBody_SignUp_txtName");
	By mobileField = By.id("ctl00_phBody_SignUp_txtEmail");
	By countryCodeDropdown = By.id("ctl00_phBody_SignUp_ddlCountryMobileCode");
	By notARobotCheckbox = By.id("recaptcha-anchor-label");
	By continueButton = By.id("ctl00_phBody_SignUp_btnContinue");

	// Constructor
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Methods
	public void enterName(String name) {
		WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
		nameElement.clear();
		nameElement.sendKeys(name);
	}

	public void enterMobileNumber(String mobile) {
		WebElement mobileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));
		mobileElement.clear();
		mobileElement.sendKeys(mobile);
	}

	public void selectCountryCode(String countryCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout
		try {
			// Wait for the dropdown to be visible
			WebElement countryDropdown = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_phBody_SignUp_ddlCountryMobileCode")));

			// Select the country code
			Select select = new Select(countryDropdown);
			select.selectByVisibleText(countryCode);

			System.out.println("✅ Country code selected: " + countryCode);
		} catch (Exception e) {
			System.out.println("❌ Country code selection failed: " + e.getMessage());

			// Fallback: Use JavaScript to select the dropdown
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"document.getElementById('ctl00_phBody_SignUp_ddlCountryMobileCode').value='" + countryCode + "';");
		}
	}

	public void clickNotARobot() {
		try {
//            WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(notARobotCheckbox));
//            new Actions(driver).moveToElement(captcha).click().perform();
			Thread.sleep(20000);
		} catch (Exception e) {
			System.out.println("CAPTCHA handling requires manual intervention.");
		}
	}

	public void clickContinue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Click the Continue button
			WebElement continueButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_phBody_SignUp_btnContinue")));
			continueButton.click();

			// Wait for the URL to change to OTP page
			wait.until(ExpectedConditions.urlContains("OTP sent to Mobile\r\n"
					+ "                "));
			System.out.println("✅ Navigated to OTP page: " + driver.getCurrentUrl());
		} catch (TimeoutException e) {
			System.out.println("❌ Timeout: Did not reach OTP page.");
			System.out.println("📌 Current URL: " + driver.getCurrentUrl());

			// Capture any validation error messages on the signup page
			try {
				WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
				System.out.println("⚠️ Signup Error Message: " + errorMessage.getText());
			} catch (NoSuchElementException ex) {
				System.out.println("✅ No visible error messages, possible CAPTCHA issue.");
			}

			throw e; // Rethrow exception to fail test
		}
	}
}
