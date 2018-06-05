Feature: PDP Add to cart functionality

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.

  Scenario: Check that shopper can add product with QTY 1 to cart.
    Given PDP for any product.
    When Set QTY values for products to 1 on PDP.
    And Click on Add to cart button on PDP.
    And Click on Checkout button in Add to cart pop-up on PDP.
    Then Check that selected products exist on Cart page.
#    And Check that selected product have corresponding quantities on Cart page.