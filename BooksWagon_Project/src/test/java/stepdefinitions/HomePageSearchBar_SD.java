package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SearchBarPage;
import utilities.BaseClass;

public class HomePageSearchBar_SD {
	
	WebDriver driver = BaseClass.getDriver();
	SearchBarPage searchBar = new SearchBarPage(driver);
	
	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		searchBar.userOnHomePage();
	}

	@Then("I should see the search bar")
	public void i_should_see_the_search_bar() {
		searchBar.userValidateSearchBar();
	}
}
