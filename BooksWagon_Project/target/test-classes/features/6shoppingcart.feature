Feature: Shopping cart functionality

  Scenario: Add an item to the shopping cart
  	Given User added a product to the cart
  	When User update item quantity in the shopping cart
  	And The shopping cart should reflect the updated quantity
		And User remove item from the shopping cart
		Then The shopping cart should be empty
		
		Scenario: Checkout with items in cart
 		 Given The user has a product in the shopping cart
 		 When The user proceeds to the checkout page
  	 Then The checkout page should display


	  