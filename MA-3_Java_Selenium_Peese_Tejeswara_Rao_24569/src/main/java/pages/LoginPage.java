package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By usernameField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.xpath("//button[@class='button-1 login-button']");
    private By logoutLink = By.linkText("Log out");  // ✅ Indicator of successful login

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // ✅ Wait for elements
    }

    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isUserLoggedIn() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isUserLoggedOut() {
        try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
