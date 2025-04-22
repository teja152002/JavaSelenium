package stepdefinition;

import utilities.BaseClass;
import pages.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

public class OrderSteps extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OrderConfirmationPage orderConfirmationPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        BaseClass.initialize();  // ✅ Fix for NullPointerException
        loginPage = new LoginPage(driver);
        driver.get("https://demo.nopcommerce.com/");
    }

    @When("User enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        driver.findElement(By.linkText("Log in")).click();  // ✅ Fixed locator
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLogin();
        try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        homePage = new HomePage(driver);  // ✅ Ensuring object is initialized
        Assert.assertTrue(homePage.isUserLoggedIn());
    }

    @When("User navigates to Electronic menu")
    public void user_navigates_to_electronic_menu() {
        homePage.navigateToElectronics();
    }

    @When("User clicks on Cell Phones")
    public void user_clicks_on_cell_phones() {
        homePage.clickCellPhones();
    }

    @When("User selects the 3rd product")
    public void user_selects_the_3rd_product() {
        productPage = new ProductPage(driver);  // ✅ Ensuring object is initialized
        productPage.selectThirdProduct();
    }

    @When("User clicks the Add to cart button")
    public void user_clicks_the_add_to_cart_button() {
        productPage.addToCart();
    }

    @Then("Product should be added to cart")
    public void product_should_be_added_to_cart() {
        Assert.assertTrue(productPage.isProductAddedToCart());
    }

    @When("User moves to Shopping cart")
    public void user_moves_to_shopping_cart() {
        cartPage = new CartPage(driver);  // ✅ Ensuring object is initialized
        cartPage.navigateToCart();
    }

    @When("User clicks Go to Cart button")
    public void user_clicks_go_to_cart_button() {
        cartPage.goToCart();
    }

    @When("User selects Yes for Gift wrapping")
    public void user_selects_yes_for_gift_wrapping() {
        cartPage.selectGiftWrapping();
    }

    @When("User selects I agree with the terms checkbox")
    public void user_selects_i_agree_with_the_terms_checkbox() {
        cartPage.agreeToTerms();
    }

    @When("User clicks Checkout button")
    public void user_clicks_checkout_button() {
        cartPage.clickCheckout();
    }

    @When("User fills the required fields")
    public void user_fills_the_required_fields() {
        checkoutPage = new CheckoutPage(driver);  // ✅ Ensuring object is initialized
        checkoutPage.fillCheckoutDetails();
    }

    @When("User clicks Confirm button")
    public void user_clicks_confirm_button() {
        checkoutPage.confirmOrder();
    }

    @Then("User should see the text Your order has been successfully processed")
    public void user_should_see_the_text_your_order_has_been_successfully_processed() {
        orderConfirmationPage = new OrderConfirmationPage(driver);  // ✅ Ensuring object is initialized
        Assert.assertTrue(orderConfirmationPage.isOrderSuccessful());
    }

    @When("User clicks logout")
    public void user_clicks_logout() {
        homePage.logout();
    }

    @Then("User should be logged out successfully")
    public void user_should_be_logged_out_successfully() {
        Assert.assertTrue(loginPage.isUserLoggedOut());
    }
}
