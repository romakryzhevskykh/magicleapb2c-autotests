Feature: Registration functionality

  Background:
    Given Switch to Storefront cockpit independent test user.
    And User is logged out from Storefront.
    And Open Registration page.

  Scenario: Check that user can register to Storefront.
    When Generate any random User information.
    And Fill all User information fields with generated values on Registration page.

