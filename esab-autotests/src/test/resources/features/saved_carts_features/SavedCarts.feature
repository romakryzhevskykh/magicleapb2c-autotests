Feature: Saved Carts feature
Scenario: Saved Cart scen1
    #HOME PAGE
	Given Switch to Storefront shopper. 
	Given Opened Start page.
	And Login to Storefront.
	Then Verify current page is Home page. 
	Then Check that user is logged in ESAB. 
	Then Navigate to Saved Carts page by link in the Header.
	#SAVED CARTS PAGE
	And Verify current page is Saved Carts page.
	 