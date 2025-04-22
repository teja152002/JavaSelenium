package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclass.BaseClass;

public class HomeLoan {
	WebDriver driver = null;
	WebDriverWait wait = null;

	// Constructor
	public HomeLoan(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
	By homePage = By.id("home-loan");
	By loanSlider = By.id("loanamount");
	By rate = By.id("loaninterest");
	By tenure = By.id("loanterm");

	By loanEMI = By.id("emiamount");
	By totalInterestPay = By.id("emitotalinterest");
	By totalAmount = By.id("emitotalamount");

	public void homeLoanPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(homePage));
		driver.findElement(homePage).click();
//		WebElement sliderHandle = driver.findElement(By.xpath("//div[@id='loanamountslider']/span"));
//
//		// Get slider track width to calculate exact pixels for 25%
//		WebElement sliderTrack = driver.findElement(By.id("loanamountslider"));
//		int width = sliderTrack.getSize().width;
//
//		// Calculate pixel offset for 25% position
//		int xOffset = (int) (width * 0.25);
//
//		// Move the slider handle
//		Actions actions = new Actions(driver);
//		actions.clickAndHold(sliderHandle).moveByOffset(0, xOffset).release().perform();
	}

	public void setHomeLoan(String homeLoan) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loanSlider));
		WebElement h = driver.findElement(loanSlider);
		h.clear();
		h.sendKeys(homeLoan);
	}

	public void enterInterestRate(String interestRate) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(rate));
		WebElement i = driver.findElement(rate);
		i.clear();
		BaseClass.sleep(4000);
		i.sendKeys(interestRate);
	}

	public void enterLoanTenure(String loanTenure) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(tenure));
		WebElement t = driver.findElement(tenure);
		t.clear();
		t.sendKeys(loanTenure);
	}

	public void validateHomeLoanDetails() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loanEMI));
		String l = driver.findElement(loanEMI).getText();
		System.out.println("Loan EMI : " + l);

		wait.until(ExpectedConditions.visibilityOfElementLocated(totalInterestPay));
		String ti = driver.findElement(totalInterestPay).getText();
		System.out.println("Total Interest: " + ti);

		wait.until(ExpectedConditions.visibilityOfElementLocated(totalAmount));
		String ta = driver.findElement(totalAmount).getText();
		System.out.println("Total Amount: " + ta);
	}
}
