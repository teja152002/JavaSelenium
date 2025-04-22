package baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().deleteAllCookies();
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
