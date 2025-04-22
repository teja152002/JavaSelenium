package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locator for the order success message
    private By orderSuccessMessage = By.xpath("//strong[contains(text(),'Your order has been successfully processed')]");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ensuring explicit wait
    }

    public boolean isOrderSuccessful() {
        try {
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessMessage));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;  // Returns false instead of throwing NoSuchElementException
        }
    }
}
