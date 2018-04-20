Feature: Registration form UI Layout
Scenario: Verify registration form mandatory fields
Given Switch to Storefront shopper.
	Given Opened Start page.
	And Click on Register button.
	Then Verify current page is Register page.
	Then Verify headline text on Register page.
	Then Verify second line text on Register page.
	Then Verify field label names on Register page.