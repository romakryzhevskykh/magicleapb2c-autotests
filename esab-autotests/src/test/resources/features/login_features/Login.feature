Feature: Login to ESAB site 
Scenario:
Check that shopper have possibility to log in to Storefront and first of all see home page 
	Given Switch to Storefront shopper. 
	Given Opened Start page. 
	#    When Click on Sign in button.
	And Login to Storefront. 
	Then Verify current page is Home page.
	Then Check that user is logged in ESAB. 
	
 
