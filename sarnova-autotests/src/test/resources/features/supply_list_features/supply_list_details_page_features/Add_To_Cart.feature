Feature: Add to cart from Supply list details page functionality

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.
    And Empty Cart.

  Scenario: Check that user can Add to cart single product(UOM) from Supply list details page.
    Given Not empty Supply list.
    And Opened Supply list details page.
    When Set QTY 1 to any product(UOM) on the Supply list details page.
    And Click on Add to cart button on Supply list details page.
    And Click on Checkout button in Add to cart pop-up on Supply list details page.
    Then Check that selected UOMs exist on Cart page.