package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fillCheckoutDetails() {
        // Select country
        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_CountryId")));
        new Select(country).selectByValue("104");

        // Wait for state to be available and select it
        WebElement state = wait.until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_StateProvinceId")));
        new Select(state).selectByValue("845");

        // Fill other details
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Gudur");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("9/180, Raja St");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("518466");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9391222487");

        // Click Continue for Billing Address
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='billing-buttons-container']//button[contains(text(),'Continue')]"))).click();

        // Click Continue for Shipping Method
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='shipping-method-buttons-container']//button[contains(text(),'Continue')]"))).click();

        // Click Continue for Payment Method
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='payment-method-buttons-container']//button[contains(text(),'Continue')]"))).click();

        // Click Continue for Payment Info
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='payment-info-buttons-container']//button[contains(text(),'Continue')]"))).click();
    }

    public void confirmOrder() {
        // Click Confirm Order button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='confirm-order-buttons-container']//button[contains(text(),'Confirm')]"))).click();
    }
}
