Feature: User Sign-Up on Bookswagon

  Scenario: User successfully signs up on Bookswagon
    Given User is on the Bookswagon Sign-Up page
    When User enters the name "Teja"
    And User enters the mobile number "9391222487"
    And User selects country code "India +91"
    And User clicks on I am not a robot
    And User clicks on Continue button
    Then User should be redirected to OTP verification page
    
  Scenario: User enters OTP and sets password
    Given User is on the OTP verification page
    When User enters password "Teja@1234"
    And User enters confirm password "Teja@1234"
    And User clicks on Sign up button
    Then User account should be successfully created
