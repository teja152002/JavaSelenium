package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import utilities.BaseClass;

public class ProductDetails_SD {
	WebDriver driver = BaseClass.getDriver();
	ProductPage product = new ProductPage(driver);
	
	@Given("User search for product and click for results")
	public void user_search_for_product_and_click_for_results() {
		product.searchForProduct();
	}

	@When("User select product from results")
	public void user_select_product_from_results() {
		product.selectProduct();
	}

	@Then("User should see the product title")
	public void user_should_see_the_product_title() {
		product.validateProductTitle();
	}

	@Then("User should see the product description")
	public void user_should_see_the_product_description() {
		product.validateProductDescription();
	}

	@Then("User should see the product price")
	public void user_should_see_the_product_price() {
		product.validateProductPrice();
	}

	@Then("User should see product images displayed")
	public void user_should_see_product_images_displayed() {
		product.validateProductImage();
	}

	@Then("User should see the product availability status")
	public void user_should_see_the_product_availability_status() {
		product.isAvailable();
	}

	@When("User click on the Add to Wishlist button")
	public void user_click_on_the_add_to_wishlist_button() {
		product.addToWishlist();
	}

	@Then("the product should be added to my wishlist")
	public void the_product_should_be_added_to_my_wishlist() {
		product.isWishlisted();
	}

	@When("User click on the Add to Cart button")
	public void user_click_on_the_add_to_cart_button() {
		product.addToCart();
	}

	@Then("the product should be added to my shopping cart")
	public void the_product_should_be_added_to_my_shopping_cart() {
		System.out.println(product.isAddedToCart());
	}
}
