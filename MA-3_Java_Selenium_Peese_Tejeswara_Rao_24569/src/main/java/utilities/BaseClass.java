package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    protected static WebDriver driver;

    public static void initialize() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {  // Add this method to get the driver instance
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
