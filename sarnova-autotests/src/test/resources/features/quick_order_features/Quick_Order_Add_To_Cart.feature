Feature: Quick order add to Cart functionality.

   Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Quick order list is empty.
    And Open Quick order page.
  @SmokeTest
  Scenario: Check that Add to Cart button is unable if Quick order list is empty.
    Then Check that Add to cart button is unable on Quick order page.
  @SmokeTest
  Scenario: Check that Add to Cart button is unable if Quick order list has only products with QTY 0.
    When Add 1 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 0 to all UOM on Quick order page.
    Then Check that Add to cart button is unable on Quick order page.
  @SmokeTest
  Scenario: Check that user can add single product to cart.
    Given Empty Cart.
    When Add 1 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 1 to any UOM on Quick order page.
    And Click on Add to cart button on Quick order page.
    And Click on Checkout button in Add to cart pop-up on Quick order page.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.

  Scenario: Check that user can add multiple product to cart.
    Given Empty Cart.
    When Add 2 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 1 to all UOM on Quick order page.
    And Click on Add to cart button on Quick order page.
    And Click on Checkout button in Add to cart pop-up on Quick order page.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.

  Scenario: Check that only products with QTY>0 added to cart.
    Given Empty Cart.
    When Add 3 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 3 to any UOM on Quick order page.
    And Click on Add to cart button on Quick order page.
    And Click on Checkout button in Add to cart pop-up on Quick order page.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.

  Scenario: Check that Quick order list is empty after adding to cart.
    Given Empty Cart.
    When Add 3 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 2 to any UOM on Quick order page.
    And Click on Add to cart button on Quick order page.
    And Click on Continue shopping button in Add to cart pop-up on Quick order page.
    And Refresh page.
    Then Check that Quick order list is empty on Quick order page.