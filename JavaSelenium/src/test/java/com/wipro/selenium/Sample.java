package com.wipro.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); // It is for Object Creation with respective Browser.
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi"); // It will open browser
		driver.manage().window().maximize(); // It will maximize the window while opening
		String text = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/form/div[2]/div/a")).getText();
		System.out.println(text);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		driver.close();
//		String title = driver.getTitle(); // It is used to get title of browser. And return type is String. We need to store it either print it.
//		System.out.println(title);
//		if (title.equals("Rediffmail - Free Email for Login with Secure Access")) {
//			System.out.println("Title is Matching!");
//		} else {
//			System.out.println("Title is not matching!");
//		}
		// The below 2 statements sending Id and Name to the browser
//		driver.findElement(By.id("login1")).sendKeys("teja");
//		driver.findElement(By.id("login1")).getAttribute("value"); // It will used to get the value from the input.
//		driver.findElement(By.name("passwd")).sendKeys("tejasa");
		// driver.findElement(By.xpath("//input[@id=login1]"));
//		driver.findElement(By.xpath("//*[@id=\"login1\"]")).sendKeys("Teja");
//		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1234");
//		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();// It will clear the data whatever is present in that input> data.
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1wrerew");
//		driver.findElement(
//				By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]"))
//				.click(); // This operation is used to click the button operation
//		driver.close();
//		driver.quit();

	}

}
