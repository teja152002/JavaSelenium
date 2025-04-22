package pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class SearchBarPage {
	WebDriver driver = null;
	WebDriverWait wait = null;

	// Constructor
	public SearchBarPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators

	By searchBar = By.id("ctl00_imglogo");

	// Methods
	public void userOnHomePage() {
		driver.findElement(searchBar).click();
		BaseClass.sleep(5000);
	}

	public void userValidateSearchBar() {
		WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputbar")));
		assertTrue("Search bar is not displayed!", searchBar.isDisplayed());
		System.out.println("Search bar displayed succefully !");

	}

}
