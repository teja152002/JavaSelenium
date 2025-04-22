package com.selenium.webapps.task;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tricentis {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sampleapp.tricentis.com/101/index.php#");

		// Get a Quote
		WebElement weGet = driver.findElement(By.xpath("//*[@id=\"nav_automobile\"]"));
		weGet.click();

		// Make
		WebElement weSelect = driver.findElement(By.xpath("//*[@id=\"make\"]"));
		Select s1 = new Select(weSelect);
		s1.selectByValue("Audi");

		// Engine Performance
		driver.findElement(By.xpath("//*[@id=\"engineperformance\"]")).sendKeys("1500");

		// Data of manufacture
		driver.findElement(By.xpath("//*[@id=\"dateofmanufacture\"]")).sendKeys("02/02/2002");

		// Number of seats
		WebElement weSeats = driver.findElement(By.xpath("//*[@id=\"numberofseats\"]"));
		Select s2 = new Select(weSeats);
		s2.selectByValue("2");

		// Fuel Type
		WebElement weFuel = driver.findElement(By.xpath("//*[@id=\"fuel\"]"));
		Select sFuel = new Select(weFuel);
		sFuel.selectByValue("Petrol");

		// List Price
		driver.findElement(By.xpath("//*[@id=\"listprice\"]")).sendKeys("99999");

		// License Plate Number
		driver.findElement(By.xpath("//*[@id=\"licenseplatenumber\"]")).sendKeys("AP 01 1514");

		// Annual Mileage [mi]
		driver.findElement(By.xpath("//*[@id=\"annualmileage\"]")).sendKeys("10000");

		// Next
		driver.findElement(By.xpath("//*[@id=\"nextenterinsurantdata\"]")).click();

		// First Name
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("peese");

		// Last Name
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("teja");

		// DOB
		driver.findElement(By.xpath("//*[@id=\"birthdate\"]")).sendKeys("08/15/2002");

		// Gender
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]/span")).click();

		// Address
		driver.findElement(By.xpath("//*[@id=\"streetaddress\"]")).sendKeys("Gudur");

		// Country
		WebElement weCountry = driver.findElement(By.xpath("//*[@id=\"country\"]"));

		Select sCountry = new Select(weCountry);
		sCountry.selectByValue("India");

		// Zipcode
		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("518466");

		// City
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Kurnool");

		// Occupation
		WebElement weOccupation = driver.findElement(By.xpath("//*[@id=\"occupation\"]"));
		Select sOccupation = new Select(weOccupation);
		sOccupation.selectByValue("Employee");

		// Hobbies
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]")).click();

		// Website
		driver.findElement(By.xpath("//*[@id=\"website\"]")).sendKeys("www.google.com");
		
		// picture
		
		WebElement weOpen =  driver.findElement(By.xpath("//*[@id=\"picturecontainer\"]"));
		weOpen.sendKeys("C:\\AudiPic.jpeg");
//		WebElement upload =  driver.findElement(By.id("cnp-upload"));
//		upload.click();
		//weOpen.sendKeys("F:\\TEJA\\JSpiders_EclipseIDE\\JavaSelenium\\JavaSelenium\\AudiPic.jpeg");




	}

}
