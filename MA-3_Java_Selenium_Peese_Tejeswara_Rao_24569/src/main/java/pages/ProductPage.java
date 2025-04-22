package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By thirdProduct = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a/img");
    private By addToCartButton = By.id("add-to-cart-button-18");
    private By successMessage = By.className("content");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Explicit wait
    }

    public void selectThirdProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(thirdProduct)).click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean isProductAddedToCart() {
        try {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return message.getText().contains("The product has been added to your shopping cart");
        } catch (Exception e) {
            return false;  // Handles cases where the success message does not appear
        }
    }
}
