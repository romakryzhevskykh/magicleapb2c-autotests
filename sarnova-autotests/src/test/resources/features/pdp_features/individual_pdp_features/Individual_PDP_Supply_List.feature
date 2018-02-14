Feature: Individual PDP Supply list functionality

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.
    And Empty Cart.
    And PDP for INDIVIDUAL_VALID product.

  Scenario: Check info message for Adding to cart with empty selection.
    When Set QTY values for products to 0 on PDP.
    And Click on Add to cart button on PDP.
    Then Check that Add to Supply list pop-up displays Please set non-zero quantity to products you wish to add message on PDP.

  Scenario: Check that shopper can add product(UOM) to cart.
    When Set QTY 1 to any product(UOM) on the PDP.
    And Click on Add to cart button on PDP.
    And Click on Checkout button in Add to cart pop-up on PDP.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.
