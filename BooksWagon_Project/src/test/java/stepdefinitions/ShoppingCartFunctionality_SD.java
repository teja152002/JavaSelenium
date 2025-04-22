package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import pages.ShoppingCartFunctionalityPage;
import utilities.BaseClass;

public class ShoppingCartFunctionality_SD {
	WebDriver driver = BaseClass.getDriver();
	ShoppingCartFunctionalityPage cart = new ShoppingCartFunctionalityPage(driver);
	ProductPage product = new ProductPage(driver);
	
	@Given("User added a product to the cart")
	public void user_added_a_product_to_the_cart() {
		String status = product.isAddedToCart();
		System.out.println(status);
		cart.goToCart();
	}

	@When("User update item quantity in the shopping cart")
	public void user_update_item_quantity_in_the_shopping_cart() {
		cart.updateQuantity();
	}

	@When("The shopping cart should reflect the updated quantity")
	public void the_shopping_cart_should_reflect_the_updated_quantity() {
		cart.isQuantityUpdated();
	}

	@When("User remove item from the shopping cart")
	public void user_remove_item_from_the_shopping_cart() {
		cart.removeProduct();
	}

	@Then("The shopping cart should be empty")
	public void the_shopping_cart_should_be_empty() {
		cart.isCartEmpty();
	}

	@Given("The user has a product in the shopping cart")
	public void the_user_has_a_product_in_the_shopping_cart() {
		cart.addProductToCart();
	}

	@When("The user proceeds to the checkout page")
	public void the_user_proceeds_to_the_checkout_page() {
		cart.checkoutPage();
	}

	@Then("The checkout page should display")
	public void the_checkout_page_should_display() {
		cart.displayCheckoutPage();
	}
}
