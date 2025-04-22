package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Ensures pages load within 20 sec
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Reduce implicit wait for better
																				// performance
			driver.manage().deleteAllCookies(); // Clears previous session cookies
		}
		return driver;
	}

	public static void closeDriver() {
		try {
			if (driver != null) {
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Error while closing driver: " + e.getMessage());
		}
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
