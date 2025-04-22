package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			// Set ChromeDriver path only if required
			// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

			// Optional: Use ChromeOptions to configure the driver
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized"); // Ensures the browser starts maximized
			options.addArguments("--disable-notifications"); // Blocks unnecessary pop-ups
			options.addArguments("--disable-extensions"); // Runs without extra extensions

			driver = new ChromeDriver(options);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Ensures pages load within 20 sec
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Reduce implicit wait for better performance
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
}
