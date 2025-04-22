package stepdefinition;

import org.openqa.selenium.WebDriver;

import baseclass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CarLoan;
import pages.HomeLoan;
import pages.PersonalLoan;

public class CalculatorEMI {
	WebDriver driver = BaseClass.getDriver();
	HomeLoan home = new HomeLoan(driver);
	PersonalLoan personal = new PersonalLoan(driver);
	CarLoan car = new CarLoan(driver);

	@Given("User launches EMI Calculator website")
	public void user_launches_emi_calculator_website() {
		driver.get("https://emicalculator.net/");
	}

	@When("User navigates to Home Loan EMI Calculator")
	public void user_navigates_to_home_loan_emi_calculator() {
		home.homeLoanPage();
	}

	@When("User sets Home Loan Amount {string} using slider")
	public void user_sets_home_loan_amount_using_slider(String homeLoan) {
		home.setHomeLoan(homeLoan);
	}

	@When("User enters Interest Rate for home {string}")
	public void user_enters_interest_rate_for_home(String interestRate) {
		home.enterInterestRate(interestRate);
	}

	@When("User enters Loan Tenure {string}")
	public void user_enters_loan_tenure(String loanTenure) {
		home.enterLoanTenure(loanTenure);
	}

	@Then("Validate Home Loan EMI Details")
	public void validate_home_loan_emi_details() {
		home.validateHomeLoanDetails();
	}

	@When("User navigates to Personal Loan EMI Calculator")
	public void user_navigates_to_personal_loan_emi_calculator() {
		personal.personalHomeLoanPage();
	}

	@Then("Validate Personal Loan EMI Details")
	public void validate_personal_loan_emi_details() {
		personal.validatePersonalLoanDetails();
	}

	@When("User navigates to Car Loan EMI Calculator")
	public void user_navigates_to_car_loan_emi_calculator() {
		car.carLoanPage();
	}

	@Then("Validate Car Loan EMI Details")
	public void validate_car_loan_emi_details() {
		car.validateCarLoanDetails();
	}
}
