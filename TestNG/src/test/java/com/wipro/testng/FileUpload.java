package com.wipro.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	public static void main(String[] args) {
		
		WebDriver wd = new ChromeDriver();
		wd.get("https://testautomationpractice.blogspot.com/");
		wd.manage().window().maximize();
		
		WebElement we =  wd.findElement(By.xpath("//*[@id=\"singleFileInput\"]"));
		we.sendKeys("C:\\indigo.png");
	
		wd.findElement(By.xpath("//*[@id=\"singleFileForm\"]/button")).click();
		System.out.println("File Uploaded Succefully!");
		
	}

}
