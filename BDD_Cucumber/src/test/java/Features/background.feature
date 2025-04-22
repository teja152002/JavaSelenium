

Feature: Logout Functionality

Background: User is logged in
Given User in Login page 
When user enter valid username and password
And click on sign in button
Then user logged in


  Scenario: Login
  #  Given User is logged in
    When clicks on home page
    And User clicks on logout button
    Then user is logged out
    
  Scenario: Logout
   # Given User is logged in
    When clicks on profile
    And User is seen logout button
    Then user can logged out button

