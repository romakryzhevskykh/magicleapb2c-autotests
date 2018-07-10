Feature: Checkout 
Scenario: 
	Checkout test 1
	Given Switch to Storefront shopper. 
	Given Opened Start page. 
	Given Add Product model: SCU: "1111", Qty: "1", Price: "111.00", Product name: "Product pr11", In Stock: "In Stock". 
	Given Add Product model: SCU: "2222", Qty: "2", Price: "222.00", Product name: "Product pr22", In Stock: "In Stock". 
	#Given Checkout data model: Ship To Address_StreetName: "999 South Wacker Drive", Ship To Address_StreetNumber: "", Ship To Address_PostalCode: "60606", Ship To Address_Town: "Chicago", Ship To Address_Country: "USA", Requested Delivery Date: "09/05/2018", Partial Delivery Allowed: "Yes", Account: "12345", Packaging Instructions: "Packaging Instruction", Shipping Instructions: "Shipping Instruction", Purchase Order Number: "987".
	Given Checkout data model: Ship To Address_StreetName: "StreetName", Ship To Address_StreetNumber: "StreetNumber", Ship To Address_PostalCode: "PostalCode", Ship To Address_Town: "Town", Ship To Address_Country: "USA", Requested Delivery Date: "09/05/2018", Partial Delivery Allowed: "Yes", Account: "12345", Packaging Instructions: "Packaging Instruction", Shipping Instructions: "Shipping Instruction", Purchase Order Number: "987". 
	And Login to Storefront. 
	Then Verify current page is Home page. 
	Then Navigate to Shopping Cart by icon in the header.
	#SHOPPING CART PAGE 
	Then Verify current page is Shopping Cart page. 
	And Verify Ship-To address value on Shopping Cart. 
	And Select Ship To address on Shopping Cart. 
	Then Fill in SCU and Qty from Product Model. 
	And Click on Add these products to shopping cart button. 
	And Save Product Price, Product Total Price, Products Subtotal of Products on Shopping Cart page.
	And Verify Check Out button label. 
	And Click on Check Out button. 
	#SHIPPING ADDR PAGE
	Given Verify is Current page Shipping Address page. 
	And Verify Ship To Address on Shipping Address page. 
	Given Checkout data model: Ship To Address_StreetName: "999 South Wacker Drive", Ship To Address_StreetNumber: "", Ship To Address_PostalCode: "60606", Ship To Address_Town: "Chicago", Ship To Address_Country: "USA", Requested Delivery Date: "09/05/2018", Partial Delivery Allowed: "Yes", Account: "1231232", Packaging Instructions: "Packaging Instruction", Shipping Instructions: "Shipping Instruction", Purchase Order Number: "987". 
	And Click on Modify Address button on Shipping Address page. 
	And Verify Shipping address text in Modify address popup on Shipping Address page. 
	And Click on Address in Popup on Shipping Address page. 
	And Verify Ship-To address value on Shopping Cart. 
	And Click on Check Out button. 
	And Verify Ship To Address on Shipping Address page. 
	And Click on Modify Address button on Shipping Address page. 
	And Click on Close Modify Address button on Shipping Address page. 
	And Clear Shipping Instructions field on Shipping Information page. 
	And Clear Packaging Instructions input on Shipping Address page. 
	And Clear Requested Delivery Date on Shipping Address page. 
	And Click on Next Button on Shipping Address page. 
	And Verify Shipping Instructions validation message on Shipping Address page. 
	#And Verify is Current page Shipping Address page.
	And Verify is Current page Shipping Address page after validation error. 
	And Fill in Shipping Instructions on Shipping Address page. 
	And Fill in Packaging Instructions on Shipping Address page. 
	And Fill in Requested Deliver Date on Shipping Address page. 
	And Click on Partial Delivery Radio Button According to Checkout Data Model on Shipping Address page. 
	And Click on Next Button on Shipping Address page.
	#PAYMENT TYPE PAGE 
	Given Verify Payment Type page opened. 
	And Clear Purchase Order Number field on Payment Type page. 
	And Click on Next on Payment Type page. 
	And Verify validation error text on Payment Type page.
	And Verify Payment Type page opened.
	And Fill in Purchase Order Number on Payment Type page. 
	And Click on Next on Payment Type page. 
	#ORDER REVIEW PAGE
	And Verify current page is Order Review page.
	And Verify header on Order Review page.
	And Verify Purchase order number on Order Review page.
	And Verify Ship To, Sold To address on Order Review page.
	And Verify Account Number on Order Review page.
	And Verify Requested Delivery Date on Order Review page.
	And Verify Allow Partial Delivery on Order Review page.
	And Verify Packaging Instrictions on Order Review page.
	And Verify Shipping Instructions on Order Review page.
	And Verify Place Order button is Disabled on Order Review page. 
	And Click on confirmation Checkbox on Order review page. 
	And Click on Place Order button on Order Review page.