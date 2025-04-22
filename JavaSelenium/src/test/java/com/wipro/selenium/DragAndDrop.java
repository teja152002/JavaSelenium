package com.wipro.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("https://testautomationpractice.blogspot.com/");
		wd.manage().window().maximize();
		WebElement draggable = wd.findElement(By.id("draggable"));
		WebElement droppable = wd.findElement(By.id("droppable"));

		Actions action = new Actions(wd);
		action.dragAndDrop(draggable, droppable).build().perform();
		
		System.out.println("Drag and Drop Performed!");
	}

}
