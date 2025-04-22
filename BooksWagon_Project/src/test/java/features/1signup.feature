Feature: User Sign-Up on Bookswagon

  Scenario: User successfully signs up on Bookswagon
    Given User is on the Bookswagon Sign-Up page
    When User enters the name
    And User selects country code
    And User enters the mobile number
    And User clicks on I am not a robot
    And User clicks on Continue button
    Then User should be redirected to OTP verification page
    
    Given User is on the OTP verification page
    When User enters password
    And User enters confirm password
    And User clicks on Sign up button
    Then User account should be successfully created
