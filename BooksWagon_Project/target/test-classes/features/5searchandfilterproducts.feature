Feature: Search and Filter Products

  As a user of the e-books website,
  I want to search for products and apply filters for Discounts, Price, and Language
  So that I can find products that match my preferences.

  Scenario: Search for a product and filter results by Discounts, Price, and Language
    When I enter name into the search bar
    And I click on the search button
    Then I should see a list of products related to preference
    
    When I apply a price filter
    And I apply a discount filter
    And I apply a language filter
    Then I should see filtered products
