package com.wipro.testng.webapps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IRCTC_Booking {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		;
	}

	@Test
	void from() {
		// Enter 'From' station
		WebElement fromInput = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='origin']/span/input")));
		fromInput.sendKeys("SECUNDERABAD JN - SC");

		// Select the first suggested station
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']/li[1]"))).click();
	}

	@Test
	void to() {
		// Enter 'To' station
		WebElement toInput = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='destination']/span/input")));
		toInput.sendKeys("NEW DELHI - NDLS");

		// Select the first suggested station
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']/li[1]"))).click();
	}

	@Test
	void date() {
//      // Select Date (Click date picker and choose a date)
//      WebElement datePicker = driver.findElement(By.xpath("//*[@id='jDate']/span/input"));
//      datePicker.click();
//      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='5']"))).click(); // Selects 4th of the month

		WebElement date = driver.findElement(By.xpath("//span[contains(@class, 'ui-calendar')]//input"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", date);

		date.sendKeys("05/03/2025");
		date.sendKeys(Keys.ENTER);
	}

}
