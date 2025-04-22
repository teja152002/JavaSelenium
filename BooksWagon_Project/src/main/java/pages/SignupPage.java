package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class SignupPage {
	WebDriver driver = null;
	WebDriverWait wait = null;

	public boolean isRegistered = false;
	public static boolean isLoggedIn = false;

	// Constructor
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
	By nameField = By.id("ctl00_phBody_SignUp_txtName");
	By mobileField = By.id("ctl00_phBody_SignUp_txtEmail");
	By countryCodeDropdown = By.id("ctl00_phBody_SignUp_ddlCountryMobileCode");
	By notARobotCheckbox = By.id("recaptcha-anchor-label");
	By continueButton = By.id("ctl00_phBody_SignUp_btnContinue");

	// By otpField = By.id("txtOTP"); // Uncomment if OTP input is needed
	By passwordField = By.id("ctl00_phBody_SignUp_txtPassword");
	By confirmPasswordField = By.id("ctl00_phBody_SignUp_txtConfirmPwd");
	By signUpButton = By.id("ctl00_phBody_SignUp_btnSubmit");
	By successMessage = By.id("privacypolicy");

	public void userOnSignUpPage() {
		Actions actions = new Actions(driver);
		WebElement myAccount = driver.findElement(By.xpath("//span[@id='ctl00_lblUser']"));
		actions.moveToElement(myAccount).perform();

		WebElement signUpButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'New to Bookswagon?')]")));
		signUpButton.click();
	}

	public void enterName() {
		WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
		nameElement.clear();
		nameElement.sendKeys("Teja");

	}

	public void enterMobile() {
		WebElement mobileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));
		mobileElement.clear();
		mobileElement.sendKeys("9391222487");
	}

	public void countryCode() {
		WebElement countryDropdown = driver.findElement(countryCodeDropdown);
		// Select the country code
		Select select = new Select(countryDropdown);
		select.selectByValue("IN +91");
	}

	public void iamNotRobot() {
		BaseClass.sleep(20000);

	}

//	public void clickContinue() {
//		driver.findElement(continueButton).click();
//		String expected = driver.findElement(By.id("ctl00_phBody_SignUp_lblmsg")).getText();
//		String original = "The mobile number you entered already exist.";
//		if (original.equals(expected)) {
//			System.out.println("The mobile number is already registerd. Please Login !");
//			isRegistered = true;
//			driver.close();
//		} else {
//			System.out.println("Redirecting you to OTP page!");
//		}
//	}

	public void clickContinue() {
		driver.findElement(continueButton).click();
		String expected = driver.findElement(By.id("ctl00_phBody_SignUp_lblmsg")).getText();
		String original = "The mobile number you entered already exist.";
		if (original.equals(expected)) {
			System.out.println("The mobile number is already registered. Redirecting to Login page!");
			isRegistered = true;
			driver.get("https://www.bookswagon.com");
		} else {
			System.out.println("Redirecting you to OTP page!");
		}
	}

	public void redirectToOtpPage() {
		BaseClass.sleep(10000);
	}

	public void otpVerification() {
		BaseClass.sleep(20000);
		System.out.println("OTP Verification succefull !");
	}

	public void enterPassword() {
		driver.findElement(passwordField).sendKeys("TejaRao@9876");
	}

	public void confirmPassword() {
		driver.findElement(confirmPasswordField).sendKeys("TejaRao@9876");
	}

	public void clickOnSignUp() {
		driver.findElement(signUpButton).click();
	}

	public boolean accountCreated() {
		String expected = driver.findElement(successMessage).getText();
		String original = "My Account";
		boolean status = expected.equals(original);
		if (status) {
			System.out.println("Sign-up successful, already logged in.");
			isLoggedIn = true;
			BaseClass.sleep(5000);
		} else {
			System.out.println("Sign-up failed.");
		}
		return status;
	}

}
