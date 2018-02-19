Feature: Login page functionality

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.
    And Empty Cart.

  Scenario: Check that Check license pop-up is not displayed on Step 2(Shipping method) for not license-restricted product.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    Then Check that Check license pop-up is not displayed on Checkout Shipping method step.

  Scenario: Check that Check license pop-up is displayed on Step 2(Shipping method) for license-restricted product.
    Given Add to cart INDIVIDUAL, LICENSE_RESTRICTED product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    Then Check that Check license pop-up is displayed on Checkout Shipping method step.

  Scenario: Check that Check license pop-up is displayed on Step 2(Shipping method) for license-restricted product.
    Given Add to cart INDIVIDUAL, LICENSE_RESTRICTED product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Select user has no license select-box on Checkout Shipping method step in License pop-up.
    And Click on Continue button on Checkout Shipping method step in License pop-up.
    Then Check that Cart page is opened.
    And Check that there are no products on Cart page.

  Scenario: Check that only license restricted products are displaying on Step 2(Shipping method).
    Given Add to cart INDIVIDUAL, LICENSE_RESTRICTED product with quantity 1.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    Then Check that Check license pop-up is displayed on Checkout Shipping method step.
    And Check that only license-restricted products are displaying in pop-up.

  Scenario: Check that only license restricted products will be removed on Step 2(Shipping method) if user has no license.
    Given Add to cart INDIVIDUAL, LICENSE_RESTRICTED product with quantity 1.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Select user has no license select-box on Checkout Shipping method step in License pop-up.
    And Click on Continue button on Checkout Shipping method step in License pop-up.
    Then Check that Checkout Shipping method step is opened.
    And Check that only selected(expected) products are displaying on Checkout page.


