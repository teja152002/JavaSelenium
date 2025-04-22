package com.wipro.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver();
		wd.get("https://testautomationpractice.blogspot.com/");
		wd.manage().window().maximize();

		TakesScreenshot ts = (TakesScreenshot) wd;
		File file = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("picture.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
