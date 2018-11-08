Feature: Individual PDP Add to cart functionality

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Empty Cart.

  @SmokeTest
  Scenario: Check info message for Adding to cart with empty selection.
    Given PDP for INDIVIDUAL, VALID product.
    When Set QTY values for products to 0 on PDP.
    Then Check that Add to cart button is unable on PDP.

  @SmokeTest
  Scenario: Check that shopper can add product(UOM) with QTY 1 to cart.
    Given PDP for INDIVIDUAL, VALID product.
    When Set QTY 1 to any product(UOM) on the PDP.
    And Click on Add to cart button on PDP.
    And Open cart page.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.

  @SmokeTest
  Scenario: Check that shopper can add product(UOM) with QTY > 1 to cart.
    Given PDP for INDIVIDUAL, VALID product.
    When Set QTY 2 to any product(UOM) on the PDP.
    And Click on Add to cart button on PDP.
    And Open cart page.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.

  @SmokeTest
  Scenario: Check that shopper can add different product UOMs with different QTYs to cart from Individual PDP.
    Given PDP for INDIVIDUAL, VALID, WITH_MORE_THAN_ONE_UOM product.
    When Set QTY 2 to any product(UOM) on the PDP.
    And Set QTY 1 to UOM from the same product that hasn't been selected on PDP.
    And Click on Add to cart button on PDP.
    And Open cart page.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.