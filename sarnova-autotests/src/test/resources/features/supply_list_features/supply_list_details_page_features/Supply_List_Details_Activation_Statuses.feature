Feature: Deactivation and activation features for products and supply lists on SLD page

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.

  Scenario: Check that user can deactivate Supply list from SLDP.
    Given Active Supply list exists.
    And Opened Supply list details page.
    When Click on deactivate button on Supply list details page.
    Then Check that Supply list is deactivated on Supply list details page.
    Then Open Supply lists page.
    And Click on Show inactivate entries checkbox on Supply lists page.
    And Check that selected Supply list is deactivated on Supply lists page.

  Scenario: Check that user can activate Supply list from SLDP.
    Given Inactive Supply list exists.
    And Opened Supply list details page.
    When Click on activate button on Supply list details page.
    Then Check that Supply list is activated on Supply list details page.
    Then Open Supply lists page.
    And Check that selected Supply list is activated on Supply lists page.