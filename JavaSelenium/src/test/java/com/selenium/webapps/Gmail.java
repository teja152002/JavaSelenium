package com.selenium.webapps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {
	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("https://accounts.google.com/v3/signin/identifier?authuser=0&continue=https%3A%2F%2Fmail.google.com%2Fmail&ec=GAlAFw&hl=en&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S268543257%3A1740478716222195&ddm=1");
		
		String pageTitle = wd.getTitle();
		System.out.println(pageTitle);
		
		if(pageTitle.equals("Gmail")) {
			System.out.println("Title is matching!");
		}else {
			System.out.println("Title is not matching!");
		}
		
		wd.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("teja@gmail.com");
		Thread.sleep(5000);
		wd.findElement(By.xpath("//*[@id=\"identifierId\"]")).clear();
		Thread.sleep(5000);
		wd.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("teja12345@gmail.com");
		Thread.sleep(5000);
		wd.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
				
		
	}
}
