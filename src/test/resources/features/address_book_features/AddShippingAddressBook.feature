Feature: Feature: Add Shipping Address book functionality

  Background: Switch to Storefront user
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.

#  @TestCaseId("")
  Scenario: Check that logged in user can open Add Shipping Address Book page
    Given Open Add Shipping Address page.
    Then Check that page title is visible on Add Shipping Addresses page.

#  @TestCaseId("")
  Scenario: Check that logged in user can open Add Shipping Address Book and title text is equal to Add Shipping Address
    Given Add Shipping Address page is opened.
    Then Check that page title text is equal to Add Address on Add Shipping Addresses page.

  Scenario: Check that user can add new Shipping Address with only mandatory fields on Add Shipping Address page
    Given Open Add Shipping Address page.
    And VALID Shipping address that does not exist is generated.
    When Select country from drop-down on Add Shipping Address page.
    When Select Title from drop-down on Add Shipping Address page.
    And Fill First name on Add Shipping Address page.
    And Fill Last name on Add Shipping Address page.
    And Fill Address line 1 field on Add Shipping Address page.
    And Fill City field on Add Shipping Address page.
    And Fill State field on Add Shipping Address page.
    And Fill Zip code field on Add Shipping Address page.
    And Click on Save button on Add Shipping Address page.
    Then Check that flash/info message is Your address was created. on Add Shipping Address book page.
    And Open Shipping Addresses page.
    And Check that Shipping address is present on Shipping Addresses page.