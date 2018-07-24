Feature: Saved Carts feature
Scenario: Save Cart and Verify
    #HOME PAGE
	Given Switch to Storefront shopper. 
	Given Opened Start page.
	Given Add Product model: SCU: "1111", Qty: "1", Price: "111.00", Product name: "Product pr11", In Stock: "In Stock". 
	Given Add Product model: SCU: "2222", Qty: "2", Price: "222.00", Product name: "Product pr22", In Stock: "In Stock".
	And Login to Storefront.
	Then Verify current page is Home page. 
	Then Check that user is logged in ESAB.
	Then Navigate to Saved Carts page by link in the Header.
	#SAVED CARTS PAGE
	And Verify current page is Saved Carts page.
	And Get number of saved carts on Saved Carts page.
	And Navigate to Shopping Cart by icon in the header.
	#SHOPPING CART PAGE
	Then Verify current page is Shopping Cart page. 
	Then Fill in SCU and Qty from Product Model. 
	And Click on Add these products to shopping cart button. 
	And Save Products information added to the cart on Shopping Cart page.
	And Click on Save shopping cart button. 
	And Verify is Save Cart button disabled in Save Cart Popup on Shopping Cart page.
	And Fill in Shopping cart name: "Shopping Cart 1" in Save Cart Popup on Shopping Cart page.
	And Fill in Shopping cart description: "Shopping Cart Description 1" in Save Cart Popup on Shopping Cart page.
	And Click on Save button in Save Cart popup on Shopping page.
	Then Navigate to Saved Carts page by link in the Header.
	#SAVED CARTS PAGE
	And Verify current page is Saved Carts page.
	And Get number of saved carts on Saved Carts page.
	And Navigate to Shopping Cart by icon in the header.
	#SHOPPING CART PAGE
	And Verify number of saved carts on Shopping Cart page.
	And Click on Saved Carts button on Shopping Cart page.
	And Click on Saved Cart name on Saved Carts page.
	#SAVED CART DETAILS
	And Verify current page is Saved Cart Details Page.
	
	 