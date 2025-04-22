Feature: Order Placement on nopCommerce demo store

  Scenario: User successfully places an order
    Given User is on the login page
    When User enters valid username "lovelyteja86884@gmail.com" and password "TejaRao@9876"
    And User clicks the login button
    Then User should be logged in successfully
    
    When User navigates to Electronic menu
    And User clicks on Cell Phones
    And User selects the 3rd product
    And User clicks the Add to cart button
    Then Product should be added to cart
    
    When User moves to Shopping cart
    And User clicks Go to Cart button
    And User selects Yes for Gift wrapping
    And User selects I agree with the terms checkbox
    And User clicks Checkout button
    
    When User fills the required fields
    And User clicks Confirm button
    Then User should see the text Your order has been successfully processed
    
    When User clicks logout
    Then User should be logged out successfully
    
    
    