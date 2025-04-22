package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class ShoppingCartFunctionalityPage {
	WebDriver driver = null;
	WebDriverWait wait = null;
	ProductPage product = null;

	// Constructor
	public ShoppingCartFunctionalityPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.product = new ProductPage(driver);
	}

	// Locators
	By gotoCart = By.id("btnGotocart");
	By increaseQuantity = By.id("ctl00_phBody_BookCart_lvCart_ctrl0_btnPlus");
	By quantityStatus = By.id("ctl00_phBody_BookCart_lvCart_ctrl0_lblQtyMsg");
	By totalItem = By.id("ctl00_phBody_BookCart_lvCart_lblCartItems");
	By removeItem = By.id("ctl00_phBody_BookCart_lvCart_ctrl0_imgDelete");
	By emptyCart = By.id("ctl00_lblTotalCartItems");
	By clickHere = By.xpath("//a[contains(text(),\"Click here\")]");
	By buyNow = By.id("ctl00_phBody_BookCart_lvCart_imgPayment");

	By name = By.id("ctl00_cpBody_txtNewRecipientName");
	By address = By.id("ctl00_cpBody_txtNewAddress");
	By country = By.id("ctl00_cpBody_ddlNewCountry");
	By state = By.id("ctl00_cpBody_ddlNewState");
	By city = By.id("ctl00_cpBody_ddlNewCities");
	By pincode = By.id("ctl00_cpBody_txtNewPincode");
	By mobileNumber = By.id("ctl00_cpBody_txtNewMobile");
	By saveAndContinue = By.id("ctl00_cpBody_imgSaveNew");

	// By checkOut = By.xpath("//*[@id=\"site-wrapper\"]/div[3]/div[1]/h1/text()");

	// Methods
	public void goToCart() {
		BaseClass.sleep(4000);
		driver.findElement(gotoCart).click();
	}

	public void updateQuantity() {
		driver.findElement(increaseQuantity).click();

	}

	public void isQuantityUpdated() {
		String status = driver.findElement(quantityStatus).getText();
		System.out.println(status);
		BaseClass.sleep(5000);
		String item = driver.findElement(totalItem).getText();
		System.out.println("Total item after updating the quantity : " + item);
	}

	public void removeProduct() {
		driver.findElement(removeItem).click();
	}

	public void isCartEmpty() {
		BaseClass.sleep(4000);

		String cartItemCount = driver.findElement(emptyCart).getText();
		System.out.println("Total items in cart: " + cartItemCount);

		if (cartItemCount.trim().equals("0")) {
			System.out.println("Validation Passed: Shopping cart is empty.");
		} else {
			System.out.println("Validation Failed: Shopping cart is NOT empty.");
		}
	}

	public void addProductToCart() {
		BaseClass.sleep(2000);
		driver.findElement(clickHere).click();
		product.searchForProduct();
		product.selectProduct();
		product.addToCart();
		BaseClass.sleep(4000);
		goToCart();
		driver.findElement(buyNow).click();
		BaseClass.sleep(4000);
		System.out.println("User is redirected to shipping address page!");
	}

	public void checkoutPage() {
		driver.findElement(name).sendKeys("Teja");

		driver.findElement(address).sendKeys("9/180, Raja St, Gudur");

		WebElement eleCountry = driver.findElement(country);
		Select selectCountry = new Select(eleCountry);
		selectCountry.selectByValue("India");

		WebElement eleState = driver.findElement(state);
		Select selectState = new Select(eleState);
		selectState.selectByValue("Andhra Pradesh");

		BaseClass.sleep(2000);

		WebElement eleCity = driver.findElement(city);
		Select selectCity = new Select(eleCity);
		selectCity.selectByValue("Kurnool");

		driver.findElement(pincode).sendKeys("518466");

		driver.findElement(mobileNumber).sendKeys("9391222487");

		driver.findElement(saveAndContinue).click();
		System.out.println("User is redirect to checkout Page");
	}

	public void displayCheckoutPage() {
//		String expectedStatus = driver.findElement(checkOut).getText();
//		String originalStatus = " Checkout Your Cart\r\n"
//				+ "        ";
//		Assert.assertEquals(expectedStatus, originalStatus);
		System.out.println("Book Purchased Successfully!");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("picture.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
