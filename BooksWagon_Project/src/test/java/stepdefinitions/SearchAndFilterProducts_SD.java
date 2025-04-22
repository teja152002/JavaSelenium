package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchAndFilterProductPage;
import utilities.BaseClass;

public class SearchAndFilterProducts_SD {
	WebDriver driver = BaseClass.getDriver();
	SearchAndFilterProductPage searchFilter = new SearchAndFilterProductPage(driver);

	@When("I enter name into the search bar")
	public void i_enter_name_into_the_search_bar() {
		searchFilter.enterNameToSearch();
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		searchFilter.clickOnSearchButton();
	}

	@Then("I should see a list of products related to preference")
	public void i_should_see_a_list_of_products_related_to_preference() {
		searchFilter.isRelatedBooks();
	}

	@When("I apply a price filter")
	public void i_apply_a_price_filter() {
		searchFilter.applyingPriceFilter();
	}

	@When("I apply a discount filter")
	public void i_apply_a_discount_filter() {
		searchFilter.applyingDisconutFilter();
	}

	@When("I apply a language filter")
	public void i_apply_a_language_filter() {
		searchFilter.applyingLanguageFilter();
	}

	@Then("I should see filtered products")
	public void i_should_see_filtered_products() {
		searchFilter.isFilteredBooks();
	}

}
