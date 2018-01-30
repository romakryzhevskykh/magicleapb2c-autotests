Feature: Individual PDP Supply list functionality

  Background:
    Given Switch to Storefront shopper.

  Scenario: Check info message for Adding to supply list with empty selection.
    Given PDP for INDIVIDUAL_VALID product.
    And Set QTY values for products to 0.
    When Click on add to Supply list button.
    Then Pop-up with Please set non-zero quantity to products you wish to add message is opened.

  Scenario: