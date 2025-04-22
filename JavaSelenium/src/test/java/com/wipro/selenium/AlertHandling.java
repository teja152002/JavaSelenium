package com.wipro.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AlertHandling {
	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("https://testautomationpractice.blogspot.com/");
		wd.manage().window().maximize();
		
// ------------------------------------------------------------------
		// Alert Operation
//		Thread.sleep(1000);
//		wd.findElement(By.xpath("//*[@id=\"alertBtn\"]")).click();
//		Alert alert = wd.switchTo().alert(); // It will instantiate the Alert interface where we will get the method
//												// like accept(), dismiss() to handle the alert box.
//		Thread.sleep(1000);
//		alert.accept(); // This method is used to accepting the alert box.
//		wd.findElement(By.xpath("//*[@id=\"confirmBtn\"]")).click();
//		Thread.sleep(1000);
//		String text = alert.getText(); // this method is used to get the text of alert button.
//		System.out.println(text);
//		// alert.dismiss(); // This method is used to rejecting the alert box.
//		alert.accept();
//		wd.findElement(By.xpath("//*[@id=\"promptBtn\"]")).click();
//		Thread.sleep(2000);
//		alert.sendKeys("teja");
//		Thread.sleep(2000);
//		alert.accept();
		
//		wd.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[3]/div[1]/label")).click();
//		
//		wd.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[4]/div[5]/label")).click();
//		
//		wd.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("India");
//		
//		wd.findElement(By.xpath("//*[@id=\"colors\"]/option[6]")).click();
//		
//		wd.findElement(By.xpath("//*[@id=\"animals\"]/option[2]")).click();
//		
//		wd.findElement(By.xpath("//*[@id=\"datepicker\"]")).sendKeys("02/26/2025");
		
//		wd.findElement(By.xpath("//*[@id=\"start-date\"]")).sendKeys("02/08/2000");
//		wd.findElement(By.xpath("//*[@id=\"end-date\"]")).sendKeys("10/12/2020");
//		wd.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[8]/button")).click();
		
		// select option
//---------------------------------------------
		//1. select by value
		
//		WebElement ele =  wd.findElement(By.xpath("//*[@id=\"country\"]"));
//		Select select = new Select(ele);
		//select.selectByValue("india");
		
		//2. select by index
		//select.selectByIndex(4);
		
		//3. select by visible text
		//select.selectByVisibleText("India");
		
		
		// Action
		WebElement hover =  wd.findElement(By.xpath("//*[@id=\"HTML3\"]/div[1]/div/button"));
		Actions action = new Actions(wd);
		action.moveToElement(hover).build().perform();
	
		
		
	}

}
