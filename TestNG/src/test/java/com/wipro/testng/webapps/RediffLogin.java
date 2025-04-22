package com.wipro.testng.webapps;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RediffLogin {

	WebDriver wd;

	@BeforeTest
	void openingBrowser() {
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://mail.rediff.com/cgi-bin/login.cgi");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void login() {
		wd.findElement(By.xpath("//input[@id='login1']")).sendKeys("teja");
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("teja1234");
		
		TakesScreenshot ts = (TakesScreenshot) wd;
		File file = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("SignInPage.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		wd.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]")).click();
		

	}

	@AfterTest
	void closingBrowser() {
		System.out.println("Sign In Succefull");
	}

}
