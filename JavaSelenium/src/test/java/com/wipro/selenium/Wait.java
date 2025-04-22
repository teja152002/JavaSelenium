package com.wipro.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Implicit wait makes WebDriver to wait for a specified amount of time 
 * when trying to locate an element before throwing a NoSuchElementException.
 * 
 * 
 * The Explicit Wait in Selenium is used to tell the Web Driver to wait for 
 * certain conditions (Expected Conditions) or maximum time exceeded before
 * throwing “ElementNotVisibleException” exception. It is an intelligent kind of wait,
 * but it can be applied only for specified elements
*/

public class Wait {
	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		
		// Implicit Wait
//		wd.get("https://testautomationpractice.blogspot.com/");
//		wd.manage().window().maximize();
//
//		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Explicit Wait
		wd.get("https://www.deltadental.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/div/div/div[1]/header/div[2]/div/div/div[1]/div/div/a")));
		System.out.println("Explicit wait Loded!");
	}
}
