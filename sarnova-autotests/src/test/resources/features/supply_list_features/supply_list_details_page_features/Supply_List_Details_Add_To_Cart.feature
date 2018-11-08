Feature: Add to cart from Supply list details page functionality

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Empty Cart.

  Scenario: Check that user can Add to cart empty list of products(UOMs) from Supply list details page and cart will not be modified.
    Given Supply list with at least 1 active products.
    And Opened Supply list details page.
    When Set QTY 0 to all products(UOMs) on the Supply list details page.
    Then Check that Add to cart button is unable on Supply list details page.
    And Open cart page.
    And Check that there are no products on Cart page.

  Scenario: Check that user can Add to cart single product(UOM) from Supply list details page.
    Given Supply list with at least 1 active products.
    And Opened Supply list details page.
    When Set QTY 1 to any product(UOM) on the Supply list details page.
    And Click on Add to cart button on Supply list details page.
    And Open cart page.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.

  Scenario: Check that user can Add to cart multiple products(UOMs) with greater than 1 QTY from Supply list details page.
    Given Supply list with at least 3 active products.
    And Opened Supply list details page.
    When Set QTY 1 to any product(UOM) on the Supply list details page.
    And Set QTY 2 to any product(UOM) that hasn't been selected on the Supply list details page.
    And Click on Add to cart button on Supply list details page.
    And Open cart page.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.