package com.wipro.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Frames : No one are using Iframe now. But if you want capture frame elements first we need to go thier by swithcTo() method.
 * -> Then only it identifies the element as Frame. Else it throws an NoSuchElementFound.
 */
public class IFrame {
	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();

		wd.get("https://demo.automationtesting.in/Frames.html");

		String title = wd.getTitle();
		System.out.println(title);

		wd.switchTo().frame("SingleFrame"); // using index also we can do like wd.switchTo().frame(0);
		wd.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Teja");

		wd.switchTo().defaultContent();
		String header = wd.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/h1")).getText();
		System.out.println(header);
	}

}
