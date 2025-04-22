Feature: Change Password

  Scenario: Successfully change password
    Given the user is logged in
    And the user is redirected to the change password page
    When the user enters their old password
    And the user enters a new password
    And the user enters the new password again in the confirm password field
    Then the password is updated successfully
    And the user receives a confirmation message