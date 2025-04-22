Feature: Product Details Page Validation

  Scenario: Validate product details
  	Given User search for product and click for results
  	When User select product from results
    Then User should see the product title
    And User should see the product description
    And User should see the product price
    And User should see product images displayed
    And User should see the product availability status

    When User click on the Add to Wishlist button
    Then the product should be added to my wishlist

    When User click on the Add to Cart button
    Then the product should be added to my shopping cart

    