Feature: My Account menu items on click redirects functionality.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And My Account menu is opened.

  @SmokeTest
  Scenario: Check that Account Dashboard My Account menu item redirects to Account Dashboard page.
    When Click on Account Dashboard item in My Account menu.
    Then Check that Account Dashboard page is opened.

  @SmokeTest
  Scenario: Check that Supply Lists My Account menu item redirects to Saved Carts page.
    When Click on Supply Lists item in My Account menu.
    Then Check that Supply Lists page is opened.

  @SmokeTest
  Scenario: Check that Saved Carts My Account menu item redirects to Saved Carts page.
    When Click on Saved Carts item in My Account menu.
    Then Check that Saved Carts page is opened.

  @SmokeTest
  Scenario: Check that Previously Ordered My Account menu item redirects to Order History page.
    When Click on Previously Ordered Items item in My Account menu.
    Then Check that Previously Ordered Items page is opened.

  @SmokeTest
  Scenario: Check that Order History My Account menu item redirects to Reports page.
    When Click on Order History item in My Account menu.
    Then Check that Order History page is opened.

  @SmokeTest
  Scenario: Check that Reports My Account menu item redirects to Reports page.
    When Click on Reports item in My Account menu.
    Then Check that Reports page is opened.

  @SmokeTest
  Scenario: Check that Purchase Requests My Account menu item redirects to Purchase Requests page.
    When Click on Purchase Requests item in My Account menu.
    Then Check that Purchase Requests page is opened.

  @SmokeTest
  Scenario: Check that Quotes My Account menu item redirects to Quotes page.
    When Click on Quotes item in My Account menu.
    Then Check that Quotes page is opened.

  @SmokeTest
  Scenario: Check that Help My Account menu item redirects to Help/New To Boundtree? page.
    When Click on Help item in My Account menu.
    Then Check that Help page is opened.

  @SmokeTest
  Scenario: Check that Sign Out My Account menu item redirects to Start page.
    When Click on Sign Out item in My Account menu.
    Then Check that user is logged out.