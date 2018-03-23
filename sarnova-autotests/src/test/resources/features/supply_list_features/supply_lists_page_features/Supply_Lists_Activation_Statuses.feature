Feature: Deactivation and activation features for supply lists on Supply lists page.

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.

  Scenario: Check that user can deactivate Supply list on Supply lists page.
    Given Active Supply list exists.
    And Open Supply lists page.
    When Click on deactivate button on Supply lists page.
    And Click on Show inactivate entries checkbox on Supply lists page.
    Then Check that selected Supply list is deactivated on Supply lists page.

  Scenario: Check that user can activate Supply list on Supply lists page.
    Given Inactive Supply list exists.
    And Open Supply lists page.
    When Click on Show inactivate entries checkbox on Supply lists page.
    When Click on activate button on Supply lists page.
    And Check that selected Supply list is activated on Supply lists page.