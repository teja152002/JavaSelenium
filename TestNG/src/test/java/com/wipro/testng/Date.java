package com.wipro.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date {
	public static void main(String[] args) {
		
		WebDriver wd = new ChromeDriver();
		wd.get("https://testautomationpractice.blogspot.com/");
		wd.manage().window().maximize();
		
		WebElement date1 =  wd.findElement(By.xpath("//*[@id=\"datepicker\"]"));
		date1.sendKeys("02/02/2002");
		date1.click();	
		
		WebElement date2 = wd.findElement(By.xpath("//*[@id=\"txtDate\"]"));
		date2.sendKeys("03-02-2002");
		date2.click();
		
		
		wd.findElement(By.xpath("//*[@id=\"start-date\"]")).sendKeys("04/02/2002");
		wd.findElement(By.xpath("//*[@id=\"end-date\"]")).sendKeys("05/02/2002");
		
	}

}
