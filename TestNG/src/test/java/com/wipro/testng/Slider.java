package com.wipro.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
    public static void main(String[] args) {
        WebDriver wd = new ChromeDriver();
        wd.get("https://testautomationpractice.blogspot.com/");
        wd.manage().window().maximize();

        WebElement w1 =wd.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
		WebElement w2 =wd.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
		Actions ac = new Actions(wd);
		ac.dragAndDropBy(w1, 50, 0).perform();
		ac.dragAndDropBy(w1,-30, 0).perform();
		ac.dragAndDropBy(w2, 10, 0).perform();
	
       

    }
}
