package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By shoppingCartLink = By.linkText("Shopping cart");
    private By goToCartButton = By.linkText("Go to cart");
    private By giftWrappingDropdown = By.id("checkout_attribute_1");
    private By agreeToTermsCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton)).click();
    }

    public void selectGiftWrapping() {
        WebElement gift = wait.until(ExpectedConditions.visibilityOfElementLocated(giftWrappingDropdown));
        Select selectGift = new Select(gift);
        selectGift.selectByValue("2"); // Ensure this value matches the actual options
    }

    public void agreeToTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(agreeToTermsCheckbox)).click();
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
