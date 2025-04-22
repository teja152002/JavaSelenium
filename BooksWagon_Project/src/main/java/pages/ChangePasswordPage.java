package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ChangePasswordPage {
	WebDriver driver = null;
	WebDriverWait wait = null;

	private LoginPage loginPage;

	// Constructor
	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.loginPage = new LoginPage(driver);
	}

	// Locators
	By checkMessage = By.id("privacypolicy");
	By oldPassword = By.id("ctl00_phBody_ChangePassword_txtCurPwd");
	By newPassword = By.id("ctl00_phBody_ChangePassword_txtNewPassword");
	By newConfirmPassword = By.id("ctl00_phBody_ChangePassword_txtConfirmPwd");
	By changePasswordButton = By.id("ctl00_phBody_ChangePassword_imgSubmit");
	By confirmationMessage = By.id("ctl00_phBody_ChangePassword_lblmsg");

	// Methods
	public void isUserLogged() {
		Assert.assertTrue(loginPage.bookswagonAccount(), "User is not logged in ");
	}

	public void redirectToChangePassword() {
		Actions actions = new Actions(driver);
		WebElement myAccount = driver.findElement(By.xpath("//span[@id='ctl00_lblUser']"));
		actions.moveToElement(myAccount).perform();

		WebElement changePassword = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Change Password')]")));
		changePassword.click();

	}

	public void enterOldPassword() {
		driver.findElement(oldPassword).sendKeys("Teja@1234"); // TejaRao@9876 - Teja@1234
	}

	public void enterNewPassword() {
		driver.findElement(newPassword).sendKeys("TejaRao@9876");
	}

	public void enterNewConfirmPassword() {
		driver.findElement(newConfirmPassword).sendKeys("TejaRao@9876");
	}

	public void clickOnChangePassword() {
		driver.findElement(changePasswordButton).click();

	}

	public void changePasswordConfirmationMessage() {
		String originalMessage = "Congratulation! Your new password has been saved.";
		String expectedMessage = driver.findElement(confirmationMessage).getText();
		Assert.assertEquals(originalMessage, expectedMessage);
	}
}
