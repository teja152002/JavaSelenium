Feature: User Log in on Bookswagon

  Scenario: User successfully Log in onto Bookswagon
    Given User is on the Bookswagon Log in page
    When User enters the number
    And User enters the password
    And User clicks on Login button
    Then User should be redirected to Bookswagon Account
