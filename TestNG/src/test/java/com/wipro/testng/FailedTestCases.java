package com.wipro.testng;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FailedTestCases {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		System.out.println("Browser opened succefulyy");
	}

	@Test
	public void test1() {
		String originalTitle = "Google";
		String expectedTitle = driver.getTitle();
		assertEquals(originalTitle, expectedTitle);
	}

	@Test
	public void test2() {
		WebElement e =  driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		e.sendKeys("java selenium");
		e.sendKeys(Keys.ENTER);
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

}
