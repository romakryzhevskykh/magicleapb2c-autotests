Feature: Checkout 
Scenario: 
	Checkout test 1
	Given Switch to Storefront shopper. 
	Given Opened Start page. 
	Given Add Product model: SCU: "1111", Qty: "1", Price: "111.00", Product name: "Product pr11", In Stock: "In Stock". 
	Given Add Product model: SCU: "2222", Qty: "2", Price: "222.00", Product name: "Product pr22", In Stock: "In Stock". 
	And Login to Storefront. 
	Then Verify current page is Home page. 
	Then Navigate to Shopping Cart by icon in the header. 
	Then Verify current page is Shopping Cart page. 
	Then Fill in SCU and Qty from Product Model. 
	And Click on Add these products to shopping cart button. 
	And Verify Check Out button label. 
	And Click on Check Out button. 
	Given Verify is Current page Shipping Address page. 
	And Clear Shipping Instructions field on Shipping Information page. 
	And Click on Next Button on Shipping Address page. 
	And Verify Shipping Instructions validation message on Shipping Address page. 
	#And Verify is Current page Shipping Address page.
	And Verify is Current page Shipping Address page after validation error. 
	And Fill in Shipping Instructions on Shipping Address page. 
	And Click on Next Button on Shipping Address page. 
	Given Verify Payment Type page opened. 
	And Fill in Purchase Order Number on Payment Type page. 
	And Click on Next on Payment Type page. 
	And Verify current page is Order Review page. 
	And Verify Place Order button is Disabled on Order Review page. 
	And Click on confirmation Checkbox on Order review page. 
	#And Verify Place Order button is Disabled on Order Review page.
	And Click on Place Order button on Order Review page.