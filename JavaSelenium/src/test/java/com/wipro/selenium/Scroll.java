package com.wipro.selenium;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scroll {
	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver();
		wd.get("https://testautomationpractice.blogspot.com/");
		wd.manage().window().maximize();

		Actions action = new Actions(wd);

		// Scroll up to the element
//		WebElement right_click_button= wd.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));
//		action.scrollToElement(right_click_button).build().perform();

		// Scrolling from particular place to place using to numbers.
		JavascriptExecutor je = (JavascriptExecutor) wd;
		je.executeScript("window.scrollBy(0,2000)");
		je.executeScript("window.scrollTo(2000,0)");

	}
}