package com.wipro.testng.webapps;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Create_RediffAccount {

	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void accountCreate() {
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("Teja");

		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("pteja9876");

		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]")).click();

		driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys("Abcd@1234");

		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys("Abcd@1234");

		driver.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input"))
				.sendKeys("teja1234@gmail.com");

		driver.findElement(By.xpath("//input[@id='mobno']")).sendKeys("9391222487");

		WebElement day = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
		Select sDay = new Select(day);
		sDay.selectByValue("15");

		WebElement month = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
		Select sMonth = new Select(month);
		sMonth.selectByValue("08");

		WebElement year = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
		Select sYear = new Select(year);
		sYear.selectByValue("2002");

		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]")).click();

		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select sCountry = new Select(country);
		sCountry.selectByValue("99");

		WebElement city = driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select"));
		Select sCity = new Select(city);
		sCity.selectByValue("Bangalore");

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("AccountCreated.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//input[@id='Register']")).click();

	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("Account Created Succefully!");
	}

}
