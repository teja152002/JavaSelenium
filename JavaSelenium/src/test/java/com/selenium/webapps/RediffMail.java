package com.selenium.webapps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffMail {
	public static void main(String[] args) {
		
		WebDriver wd = new ChromeDriver();
		wd.get("https://register.rediff.com/register/register.php?FormName=user_details");
		wd.manage().window().maximize();
		wd.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("teja");
		wd.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[7]/td[3]/input[1]")).sendKeys("teja@gmail.com");
		wd.findElement(By.xpath("//*[@id=\"newpasswd\"]")).sendKeys("teja1234");
		wd.findElement(By.xpath("//*[@id=\"newpasswd1\"]")).sendKeys("teja1234");
		wd.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")).sendKeys("teja1234@gmail.com");
		wd.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys("9876543210");
		wd.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]")).sendKeys("15");
		wd.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]")).sendKeys("08");
		wd.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")).sendKeys("2002");
		wd.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select")).sendKeys("Bangalore");
		
		
	}

}
