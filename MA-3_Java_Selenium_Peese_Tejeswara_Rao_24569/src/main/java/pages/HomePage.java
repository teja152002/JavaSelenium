package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // More stable XPaths
    private By electronicsMenu = By.xpath("//div[@class='category-grid']//a[contains(@href, 'electronics')]");
    private By cellPhonesLink = By.xpath("//div[@class='sub-category-grid']//a[contains(@href, 'cell-phones')]");
    private By logoutLink = By.linkText("Log out"); // More reliable

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToElectronics() {
        driver.findElement(electronicsMenu).click();
    }

    public void clickCellPhones() {
        driver.findElement(cellPhonesLink).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElements(logoutLink).size() > 0;  // Prevents NoSuchElementException
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }
}
