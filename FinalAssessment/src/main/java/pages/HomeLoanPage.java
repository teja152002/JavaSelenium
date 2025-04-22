package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeLoanPage {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	private By loanAmountSlider = By.xpath("//div[@id='loanamountslider']//span");
	private By interestInput = By.xpath("//input[@id='homeloaninterest']");
	private By tenureInput = By.xpath("//input[@id='homeloanterm']");
	private By emiValue = By.xpath("//span[@id='emiamount']");
	private By interestPayable = By.xpath("//span[@id='emitotalinterest']");
	private By totalPayment = By.xpath("//span[@id='emitotalamount']");

	public void setLoanAmountWithSlider(int value) {
		WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(loanAmountSlider));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slider, calculateOffset(value), 0).perform();
	}

	private int calculateOffset(int loanAmount) {
		return (loanAmount / 1000000) * 100;
	}

	public void enterInterestRate(String rate) {
		WebElement interest = wait.until(ExpectedConditions.visibilityOfElementLocated(interestInput));
		interest.clear();
		interest.sendKeys(rate);
	}

	public void enterTenure(String tenure) {
		WebElement tenureField = wait.until(ExpectedConditions.visibilityOfElementLocated(tenureInput));
		tenureField.clear();
		tenureField.sendKeys(tenure);
	}

	public void validateEmiDetails() {
		String emi = wait.until(ExpectedConditions.visibilityOfElementLocated(emiValue)).getText();
		String interest = driver.findElement(interestPayable).getText();
		String total = driver.findElement(totalPayment).getText();

		System.out.println("EMI: " + emi);
		System.out.println("Total Interest Payable: " + interest);
		System.out.println("Total Payment: " + total);

		assert !emi.isEmpty() : "EMI value should not be empty";
	}
}
