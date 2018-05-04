Feature: Registration form 
Scenario: Verify registration form UI elements presence 
	Given Switch to Storefront shopper. 
	Given Opened Start page. 
	And Click on Register button. 
	Then Verify current page is Register page. 
	Then Verify headline text on Register page. 
	Then Verify second line text on Register page. 
	Then Verify field label names on Register page. 
	
Scenario: Verify registration form mandatory fields 
	Given Switch to Storefront shopper. 
	Given Opened Start page. 
	And Click on Register button. 
	Given User model:Country: 'USA', Title: 'Mr.', First and Last Name: 'Ivan Petrov', Company ID: 'Pronto', Company Name: 'Pronto', Address 1: 'Addr1', Address 2: 'Addr2', City: 'Kiev', Post Code: '123', Position: 'Position1', Telephone: '123456', Ext: '789', Email address: 'testUser@notExistentEmail.zzz', Confir email address: 'testUser@notExistentEmail.zzz', Comment: 'Clomment'. 
	Then Verify current page is Register page. 
 
	#And Select country: USA in Country dropdown.
	#And Select title: Mr. in Title dropdown.
	#And Input First name and LastName: Ivan Petrov into First and Last name field.
	#And Input Company ID: Pronto into Company ID field.
	#And Input Company Name: TestCompany into Company Name field.
	#And Input Address Line 1: TestAddr1 into Address Line 1 field.
	#And Input Address Line 2: TestAddr2 into Address Line 2 field.
	#And Input City: TestCity into City field.
	#And Input Post Code: 02125 into Post Code field.
	#And Input Ypur Position: MyPosition into Your Position field.
	#And Input Telephone: 123456789 into Telephone field.
	#And Input Ext: 123 into Ext field.
	#And Input Email Address: testUser@notExistentEmail.zzz into Email Address field.
	#And Confirm Email Address: testUser@notExistentEmail.zzz in Confirm Email Address field.
	#And Input Comment: TestingComment into Comment field.
	#And Confirm registration.
	