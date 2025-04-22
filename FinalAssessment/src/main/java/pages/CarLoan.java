package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarLoan {
	WebDriver driver = null;
	WebDriverWait wait = null;

	// Constructor
	public CarLoan(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators

	By loanEMI = By.id("emiamount");
	By totalInterestPay = By.id("emitotalinterest");
	By totalAmount = By.id("emitotalamount");

	public void carLoanPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("car-loan")));
		driver.findElement(By.id("car-loan")).click();
	}

	public void validateCarLoanDetails() {
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
