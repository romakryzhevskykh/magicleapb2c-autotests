Feature: Address book page is a page with address items

  Background: Switch to Storefront user
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.

  Scenario: Check that logged in user can open Shipping Address Book and page title is visible
    Given Shipping Addresses page is opened.
    Then Check that page title is visible on Shipping Addresses page.

  Scenario: Check that logged in user can open Shipping Address Book and title text is equal to Shipping Addresses
    Given Shipping Addresses page is opened.
    Then Check that page title text is equal to Address Book on Shipping Addresses page.

  Scenario: Check info message for empty Address book list is equals to No Saved Shipping Addresses Found
    Given User does not have Saved Shipping Addresses.
    When Open Shipping Addresses page.
    Then Check that empty list message is displayed on Shipping Addresses page.
    And Check that empty list message equals to No Saved Addresses Found on Shipping Addresses page.

  Scenario: Check that user can delete existed Shipping Address
    Given User has at least 1 Saved Shipping Addresses.
    And Choose any user Saved Shipping address.
    When Open Shipping Addresses page.
    And Click on Delete button for Shipping address on Shipping Addresses page.
    And Click on Delete button in Delete Address pop-up on Shipping Addresses page.
    Then Check that Shipping address is not present on Shipping Addresses page.
    And Refresh page.
    Then Check that Shipping address is not present on Shipping Addresses page.

  Scenario: Check that user can cancel deleting of existed Shipping Address
    Given User has at least 1 Saved Shipping Addresses.
    And Choose any user Saved Shipping address.
    When Open Shipping Addresses page.
    And Click on Delete button for Shipping address on Shipping Addresses page.
    And Click on Cancel button in Delete Address pop-up on Shipping Addresses page.
    Then Check that Shipping address is present on Shipping Addresses page.
    And Refresh page.
    Then Check that Shipping address is present on Shipping Addresses page.

  Scenario: Check that Shipping Address can be set as default on Shipping Address Book page
    Given User has at least 2 Saved Shipping Addresses.
    And Choose any not default user Saved Shipping address.
    When Open Shipping Addresses page.
    And Click on Set as Default button for Shipping address on Shipping Addresses page.
    Then Check that Shipping Address is default on Shipping Addresses page.
    And Check that other user addresses are not default on Shipping Addresses page.

  Scenario: Check that clicking on Update pencil icon redirects to Edit Shipping Address page
    Given User has at least 1 Saved Shipping Addresses.
    And Choose any user Saved Shipping address.
    When Open Shipping Addresses page.
    And Click on Edit button for Shipping Address on Shipping Addresses page.
    Then Check that Edit Shipping address page is opened.

  Scenario: Check that Add Shipping Address redirects to Add Shipping Address page
    Given Shipping Addresses page is opened.
    When Click on Add Shipping address button on Shipping Addresses page.
    Then Check that Add Shipping address page is opened.