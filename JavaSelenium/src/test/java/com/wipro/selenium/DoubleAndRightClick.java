package com.wipro.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleAndRightClick {
	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("https://testautomationpractice.blogspot.com/");
		wd.manage().window().maximize();
		
		
		// Double Click
		WebElement doubleClick =  wd.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));
		Actions actionDouble = new Actions(wd);
		actionDouble.doubleClick(doubleClick).build().perform();
		System.out.println("Double Click has Performed!");
		
		// Right Click
		WebElement rightClick =  wd.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));
		Actions action = new Actions(wd);
		action.contextClick(rightClick).build().perform();
		
	}

}
