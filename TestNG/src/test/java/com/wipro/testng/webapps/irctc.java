package com.wipro.testng.webapps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class irctc {

	WebDriver driver;

	@BeforeTest
	void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
	}

	@Test
	public void from() {
		driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input")).sendKeys("SECUNDERABAD JN - SC");
	}

	@Test
	public void to() {
		driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input")).sendKeys("NEW DELHI - NDLS");
	}

	@Test
	public void date() {
		driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/input")).click();
		driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[2]/table/tbody/tr[2]/td[5]/a")).click();
	}

	@Test
	public void allClass() {
		driver.findElement(By.xpath("//*[@id=\"journeyClass\"]/div/div[2]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"journeyClass\"]/div/div[4]/div/ul/p-dropdownitem[3]/li/span")).click();
	}

	@Test
	public void quota() {
		driver.findElement(By.xpath("//*[@id=\"journeyQuota\"]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"journeyQuota\"]/div/div[4]/div/ul/p-dropdownitem[7]/li/span")).click();
	}

	@Test
	public void checkBoxe() {
		driver.findElement(By.xpath(
				"//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[4]/div/span[2]/label"))
				.click();
	}

	@Test
	public void search() {
		driver.findElement(By.xpath(
				"//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[5]/div[1]/button"))
				.click();
	}

	@AfterTest
	void closingBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
