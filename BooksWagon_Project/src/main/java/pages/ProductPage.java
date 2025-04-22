package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.BaseClass;

public class ProductPage {
	WebDriver driver = null;
	WebDriverWait wait = null;

	// Constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
	By searchBar = By.id("inputbar");
	By clickForResults = By.id("btnTopSearch");
	By selectProduct = By.xpath("//*[@id=\"listSearchResult\"]/div[1]/div[3]/div[1]/a");
	By title = By.id("ctl00_phBody_ProductDetail_lblTitle");
	By description = By.id("ctl00_phBody_ProductDetail_lblLongDesc");
	By price = By.id("ctl00_phBody_ProductDetail_lblourPrice");
	By image = By.id("ctl00_phBody_ProductDetail_imgProduct");
	By available = By.id("ctl00_phBody_ProductDetail_lblAvailable");
	By addToWishlist = By.xpath("//a[contains(text(), 'Add to Wishlist')]");
	By isWishlisted = By.id("ctl00_lblWishlistCount");
	By addToCart = By.id("btnAddtocart");
	By isAddedToCart = By.id("lblcartmsg_16332574");

	// Methods
	public void searchForProduct() {
		WebElement search =  driver.findElement(searchBar);
		search.clear();
		search.sendKeys("rabindranath tagore");
		driver.findElement(clickForResults).click();
	}

	public void selectProduct() {
		driver.findElement(selectProduct).click();
	}

	public void validateProductTitle() {
		String productTitle = driver.findElement(title).getText();
		Assert.assertNotNull(productTitle, "Product title is null!");
		Assert.assertFalse(productTitle.isEmpty(), "Product title is empty!");
		System.out.println("Product Title: " + productTitle);
	}

	public void validateProductDescription() {
		String productDescription = driver.findElement(description).getText();
		Assert.assertNotNull(productDescription, "Product description is null!");
		Assert.assertFalse(productDescription.isEmpty(), "Product description is empty!");
		System.out.println("Product Description: " + productDescription);
	}

	public void validateProductPrice() {
		String productPrice = driver.findElement(price).getText();
		Assert.assertNotNull(productPrice, "Product price is null!");
		Assert.assertFalse(productPrice.isEmpty(), "Product price is empty!");
		System.out.println("Product Price: " + productPrice);
	}

	public void validateProductImage() {
		WebElement productImg = driver.findElement(image);
		Assert.assertTrue(productImg.isDisplayed(), "Product image is not displayed!");
		String imgSrc = productImg.getAttribute("src");
		Assert.assertNotNull(imgSrc, "Image source URL is null!");
		System.out.println("Product Image SRC: " + imgSrc);
	}

	public void isAvailable() {
		String availabilityText = driver.findElement(available).getText().trim();
		Assert.assertEquals(availabilityText, "Available", "Product availability status is incorrect!");
		System.out.println("Availability Status: " + availabilityText);
	}

	public void addToWishlist() {
		driver.findElement(addToWishlist).click();
		BaseClass.sleep(2000);
	}

	public void isWishlisted() {
		WebElement wishlistCountElement = wait.until(driver -> driver.findElement(isWishlisted));
		String countText = wishlistCountElement.getText().trim();
		BaseClass.sleep(2000);
		Assert.assertEquals(countText, "1", "Wishlist count did not update to 1 after adding!");
		System.out.println("Wishlist Count after adding: " + countText);
	}

	public void addToCart() {
		driver.findElement(addToCart).click();
		BaseClass.sleep(2000);
	}

	public String isAddedToCart() {
		WebElement cartMessageElement = wait.until(driver -> driver.findElement(isAddedToCart));
		String cartMessageText = cartMessageElement.getText().trim();
		String originalText = "Product successsfully added to the cart";

		Assert.assertEquals(cartMessageText,originalText);
		return "Cart Message: " + cartMessageText;

	}

}
