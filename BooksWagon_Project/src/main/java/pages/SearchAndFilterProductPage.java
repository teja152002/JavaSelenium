package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.BaseClass;

public class SearchAndFilterProductPage {
	WebDriver driver = null;
	WebDriverWait wait = null;

	// Constructor
	public SearchAndFilterProductPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
	By nameToSearch = By.id("inputbar");
	By searchButton = By.id("btnTopSearch");
	By verifyBook = By.xpath("//span[contains(text(),\"rabindranath tagore\")]");
	By priceFilter = By.xpath("//a[contains(text(),' Rs.100 - Rs.500 ')]");
	By discountFilter = By.xpath("//a[contains(text(),\"0% - 10%\")]");
	By languageFilter = By.xpath("//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[8]/li[2]/a");
	By filteredBooks = By.xpath("//*[@id=\"site-wrapper\"]/div[1]/div[2]/div[1]/div[1]/div");

	// Methods
	public void enterNameToSearch() {
		WebElement search = driver.findElement(nameToSearch);
		search.clear();
		search.sendKeys("rabindranath tagore");
	}

	public void clickOnSearchButton() {
		driver.findElement(searchButton).click();
	}

	public void isRelatedBooks() {
		String originalBook = "\"rabindranath tagore\"";
		String expectedBook = driver.findElement(verifyBook).getText();
		Assert.assertEquals(originalBook, expectedBook);
		System.out.println("Showing results for " + expectedBook);
		BaseClass.sleep(2000);
	}

	public void applyingPriceFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement priceFilterElement = wait.until(ExpectedConditions.visibilityOfElementLocated(priceFilter));
		priceFilterElement.click();
		System.out.println("Selected Price Range : " + priceFilterElement.getText());
		BaseClass.sleep(2000);
	}

	public void applyingDisconutFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement discountFilterElement = wait.until(ExpectedConditions.visibilityOfElementLocated(discountFilter));
		discountFilterElement.click();
		System.out.println("Selected Discount Range : " + discountFilterElement.getText());
		BaseClass.sleep(3000);
	}

	public void applyingLanguageFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement languageFilterElement = wait.until(ExpectedConditions.visibilityOfElementLocated(languageFilter));
		languageFilterElement.click();
		System.out.println("Seleted Language is : " + languageFilterElement.getText());
		BaseClass.sleep(2000);
	}

	public void isFilteredBooks() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement booksPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(filteredBooks));
		String text = booksPresent.getText();
		System.out.println(text);
	}
}
