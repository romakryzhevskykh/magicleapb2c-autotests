Feature: Deactivation and activation features for products and supply lists on SLD page

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.

  Scenario: Check that user can deactivate Supply list on SLDP.
    Given Active Supply list exists.
    And Opened Supply list details page.
    When Click on deactivate button on Supply list details page.
    Then Check that Supply list is deactivated on Supply list details page.
    Then Open Supply lists page.
    And Click on Show inactivate entries checkbox on Supply lists page.
    And Check that selected Supply list is deactivated on Supply lists page.

  Scenario: Check that user can activate Supply list on SLDP.
    Given Inactive Supply list exists.
    And Opened Supply list details page.
    When Click on activate button on Supply list details page.
    Then Check that Supply list is activated on Supply list details page.
    Then Open Supply lists page.
    And Check that selected Supply list is activated on Supply lists page.

  Scenario: Check that user can deactivate Supply list product(only one product in SL) on SLDP.
    Given Active Supply list with only 1 active products exists.
    And Opened Supply list details page.
    When Click on deactivate any product button on Supply list details page.
    Then Check that There are no active entries in this supply list message is shown on Supply list details page.
    Then Click on Show inactivate entries checkbox on Supply list details page.
    And Check that product is deactivated on Supply list details page.

  Scenario: Check that user can deactivate Supply list product(more than one active product in SL) on SLDP.
    Given Active Supply list with at least 2 active products exists.
    And Opened Supply list details page.
    When Click on deactivate any product button on Supply list details page.
    Then Click on Show inactivate entries checkbox on Supply list details page.
    And Check that product is deactivated on Supply list details page.
    And Check that other activated products did not change their statuses on Supply list details page.

  Scenario: Check that user can reactivate Supply list product on SLDP.
    Given Active Supply list with at least 1 inactive products exists.
    And Opened Supply list details page.
    And Click on Show inactivate entries checkbox on Supply list details page.
    When Click on activate any product button on Supply list details page.
    Then Check that product is activated on Supply list details page.