Feature: Shopping Cart feature 
Scenario: Check Shopping Cart Layout 
	Given Switch to Storefront shopper. 
	Given Opened Start page. 
	Given Add Product model: SCU: "1111", Qty: "1", Price: "111.00", Product name: "Product pr11", In Stock: "In Stock". 
	Given Add Product model: SCU: "2222", Qty: "2", Price: "222.00", Product name: "Product pr22", In Stock: "In Stock".
	Given Checkout data model: Ship To Address_StreetName: "999 South Wacker Drive", Ship To Address_StreetNumber: "", Ship To Address_PostalCode: "60606", Ship To Address_Town: "Chicago", Ship To Address_Country: "USA", Requested Delivery Date: "09/05/2018", Partial Delivery Allowed: "Yes", Account: "12345", Packaging Instructions: "Packaging Instruction", Shipping Instructions: "Shipping Instruction", Purchase Order Number: "987". 
	And Get list of Products. 
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
	And Verify SKU Inputs count on Shopping Cart is: "2" . 
	And Click on Add more products link on Shopping Cart. 
	And Verify SKU Inputs count on Shopping Cart is: "4" . 
	And Verify add to cart button label on Shopping Cart. 
	And Click on Add these products to shopping cart button. 
	And Verify SKU Inputs count on Shopping Cart is: "2" . 
	#Then Fill in Qty fields on Shopping Cart.
	Then Fill in SCU and Qty from Product Model. 
	And Click on Add these products to shopping cart button. 
	And Verify product names on Shopping Cart. 
	And Verify product SCU on Shopping Cart. 
	And Verify In Stock value on Shopping Cart. 
	And Verify Product Price on Shopping Cart. 
	And Verify Total Price on Shopping Cart. 
	And Verify Subtotal price on Shopping Cart.
	And Verify Save Cart button label.
	And Verify Check Out button label.
	And Click on Check Out button.
	#And Click on Save shopping cart button. 
	And Remove all products by SCU on Shopping Cart. 
	#And Verify SKU Inputs count on Shopping Cart is: "2" . 
	
	