Feature: Shopping Cart feature
Scenario: Check Shopping Cart Layout
	Given Switch to Storefront shopper. 
	Given Opened Start page. 
	#    When Click on Sign in button.
	And Login to Storefront. 
	Then Verify current page is Home page.
	Then Check that user is logged in ESAB.
	Then Navigate to Shopping Cart by icon in the header.
	Then Verify current page is Shopping Cart page.
	And Verify h2 headers on Shopping cart.