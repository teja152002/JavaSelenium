Feature: EMI Calculation

  Scenario Outline: Home Loan EMI Calculation
    Given User launches EMI Calculator website
    When User navigates to Home Loan EMI Calculator
    And User sets Home Loan Amount "<LoanAmount>" using slider
    And User enters Interest Rate for home "<InterestRate>"
    And User enters Loan Tenure "<Tenure>"
    Then Validate Home Loan EMI Details

    Examples:
      | LoanAmount | InterestRate | Tenure |
      | 5000000    | 10           | 20     |

  Scenario Outline: Personal Loan EMI Calculation
    When User navigates to Personal Loan EMI Calculator
    And User sets Home Loan Amount "<LoanAmount>" using slider
    And User enters Interest Rate for home "<InterestRate>"
    And User enters Loan Tenure "<Tenure>"
    Then Validate Personal Loan EMI Details

    Examples:
      | LoanAmount | InterestRate | Tenure |
      | 750000     | 15           | 5      |

  Scenario Outline: Car Loan EMI Calculation
    When User navigates to Car Loan EMI Calculator
    And User sets Home Loan Amount "<LoanAmount>" using slider
    And User enters Interest Rate for home "<InterestRate>"
    And User enters Loan Tenure "<Tenure>"
    Then Validate Car Loan EMI Details

    Examples:
      | LoanAmount | InterestRate | Tenure |
      | 2000000    | 9            | 6      |
