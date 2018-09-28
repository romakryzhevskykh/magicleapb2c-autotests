Feature: Registration functionality

  Background:
    Given Switch to Storefront cockpit independent test user.
    And User is logged out from Storefront.
    And Open Registration page.
  @SmokeTest
  Scenario: Check that user can register to Storefront.
    When Generate any random User information.
    And Fill all mandatory User information fields with generated values on Registration page.
    And Find any random valid Shipping address.
    And Fill all mandatory Shipping address fields with generated values on Registration page.
    And Find any random valid Billing address.
    And Fill all mandatory Billing address fields with generated values on Registration page.
    And Click on Register button on Registration page.
    Then Check that user is logged in.