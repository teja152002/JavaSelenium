package com.wipro.milestone.Java_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JPetStore {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// 1. Open the URL https://petstore.octoperf.com/
		driver.get("https://petstore.octoperf.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 2. Verify the text present “Welcome to JPetStore 6”
		String originalText = "Welcome to JPetStore 6";
		String expectedText = driver.findElement(By.xpath("//*[@id=\"Content\"]/h2")).getText();
		Assert.assertEquals(originalText, expectedText);
		System.out.println("Welcome Text Verified Succefully");

		// 3. Ensure the user navigates to the welcome page after clicking the Enter the
		// store link
		driver.findElement(By.xpath("//*[@id=\"Content\"]/p[1]/a")).click();

		// 4. Verify the no of links from the below page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links on the page: " + links.size());

		// 5. Click on the Dogs link
		driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[2]")).click();

		// 6. Verify the no of rows and columns from the below table
		WebElement table = driver.findElement(By.xpath("//div[@id='Catalog']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowCount = rows.size();
		List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
		if (columns.isEmpty()) {
			columns = rows.get(0).findElements(By.tagName("th"));
		}
		int columnCount = columns.size();
		// Printing no.of rows and columns
		System.out.println("Total Rows: " + rowCount);
		System.out.println("Total Columns: " + columnCount);

		// 7. Store the product id of “Poodle” in to a variable
		String originalProductId = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[1]/a"))
				.getText();

		// 8. Click on the K9-PO-02
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[1]/a")).click();

		// 9. Ensure the same product id appears in the below table
		String expectedProductId = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[2]"))
				.getText();
		Assert.assertEquals(originalProductId, expectedProductId);
		System.out.println("Poodle productId verified Succefully!");

		// 10. Verify the price is $18.50
		String originalPrice = "$18.50";
		String expectedPrice = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[4]")).getText();
		Assert.assertEquals(originalPrice, expectedPrice);
		System.out.println("Product Price Verified Succefully!");

		// 11. Click on Add to cart button
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a"));
		addToCartButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 12. Ensure the default quantity is “1” from the below screen
		WebElement quantityField = driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[5]/input"));
		String quantity = quantityField.getAttribute("value");
		Assert.assertEquals(quantity, "1", "Default quantity is not 1!");
		System.out.println("Test Passed: Default quantity is 1.");

	}

}
