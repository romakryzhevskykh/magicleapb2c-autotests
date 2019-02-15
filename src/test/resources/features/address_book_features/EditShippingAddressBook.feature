Feature: Edit Shipping Address book functionality

  Background: Switch to Storefront user
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.
    And User has at least 1 Saved Shipping Addresses.
    And Choose any user Saved Shipping address.

  Scenario: Check that user can edit existed Shipping Address with all possible fields
    Given WITH_ALL_FIELDS Shipping address that does not exist is generated.
    When Open Edit Shipping Address page.
    When Select country from drop-down on Edit Shipping Address page.
    And Select Title from drop-down on Edit Shipping Address page.
    And Fill First name on Edit Shipping Address page.
    And Fill Last name on Edit Shipping Address page.
    And Fill Address line 1 field on Edit Shipping Address page.
    And Fill Address line 2 field on Edit Shipping Address page.
    And Fill City field on Edit Shipping Address page.
    And Fill State field on Edit Shipping Address page.
    And Fill Zip code field on Edit Shipping Address page.
    And Fill Telephone field on Edit Shipping Address page.
    And Click on Save button on Edit Shipping Address page.
    Then Check that flash/info message is Your address was updated. on Edit Shipping Address book page.
    And Open Shipping Addresses page.
    And Check that Shipping address is present on Shipping Addresses page.

  Scenario: Check that user is redirected on Shipping Addresses page clicking on Cancel button
    Given VALID Shipping address that does not exist is generated.
    When Open Edit Shipping Address page.
    And Click on Cancel button on Edit Shipping Address page.
    Then Check that Shipping Addresses page is opened.