package com.selenium.webapps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sbi_Bank {
	public static void main(String[] args) {
		
		WebDriver wd = new ChromeDriver();
		wd.get("https://retail.onlinesbi.sbi/retail/login.htm");
		wd.manage().window().maximize();
		wd.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("teja");
		
	}

}
