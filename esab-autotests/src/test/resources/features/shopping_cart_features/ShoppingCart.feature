Feature: Shopping Cart feature
Scenario: Check Shopping Cart Layout
	Given Switch to Storefront shopper. 
	Given Opened Start page. 
	And Login to Storefront. 
	Then Verify current page is Home page.
	Then Check that user is logged in ESAB.
	Then Navigate to Shopping Cart by icon in the header.
	Then Verify current page is Shopping Cart page.
	And Verify h2 header1 on Shopping cart.
	And Verify h2 header2 on Shopping cart.
	And Verify Header2 subtitle on Shopping Cart.
	And Verify Ship-To address value on Shopping Cart.
	And Select Ship To address on Shopping Cart.