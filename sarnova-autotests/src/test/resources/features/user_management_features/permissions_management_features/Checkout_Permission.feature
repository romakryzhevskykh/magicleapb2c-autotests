Feature: Check user restrictions with CHECKOUT PERMISSION and without it.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Valid test user is present ORGANIZATION_TEST_USER.
    And Test user group is present.
    And Test user group has only CHECKOUT permission.
    And Test user has no any roles ORGANIZATION_TEST_USER.
    And Test user has only test user group assigned.

  Scenario: Check that user with only CHECKOUT PERMISSION has access to Checkout button on Cart page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    When Open cart page.
    Then Check that Checkout button is visible on Cart page.

  Scenario: Check that user with only CHECKOUT PERMISSION has access to Shipping address step on Checkout page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    When Open cart page.
    And Click on Checkout button on Cart page.
    Then Check that Checkout Shipping address step is opened.

  Scenario: Check that user with only CHECKOUT PERMISSION has access to Delivery method step on Checkout page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    When Open cart page.
    And Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Check that Checkout Shipping method step is opened.

  Scenario: Check that user with only CHECKOUT PERMISSION has access to license-restricted pop-up on Checkout page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, LICENSE_RESTRICTED product with quantity 1.
    When Open cart page.
    And Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    Then Check that Check license pop-up is displayed on Checkout Shipping method step.

  Scenario: Check that user with only CHECKOUT PERMISSION has access to Payment method step on Checkout page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    When Open cart page.
    And Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    And Check that Checkout Payment method step is opened.

  Scenario: Check that user with only CHECKOUT PERMISSION has access to Card type Payment method on Checkout page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    When Open cart page.
    And Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    Then Check that Invoice selector is visible on Checkout Payment method step.
    When Select Invoice payment type on Checkout Payment method step.
    Then Check that Purchase order number text field is visible on Checkout Payment method step.
    And Check that Comment text field is visible on Checkout Payment method step.

  Scenario: Check that user with only CHECKOUT PERMISSION has access to Invoice type Payment method on Checkout page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    When Open cart page.
    And Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    Then Check that Card selector is visible on Checkout Payment method step.
    When Select Card payment type on Checkout Payment method step.
    Then Check that Purchase order number text field is visible on Checkout Payment method step.
    And Check that Comment text field is visible on Checkout Payment method step.
    And Check that Card number text field is visible on Checkout Payment method step.
    And Check that Expiry month drop-down is visible on Checkout Payment method step.
    And Check that Expiry year drop-down is visible on Checkout Payment method step.
    And Check that Name on card text field is visible on Checkout Payment method step.
    And Check that CVV text field is visible on Checkout Payment method step.

  Scenario: Check that user with only CHECKOUT PERMISSION has access to Final Review step on Checkout page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    When Open cart page.
    And Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    When Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    Then Check that Checkout Final review step is opened.
    And Check that Place order button is visible on Checkout Final Review step.
    And Check that accept Terms and Conditions checkbox is visible on Checkout Final Review step.

  Scenario: Check that user with only CHECKOUT PERMISSION has access to place order and Order confirmation page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    When Open cart page.
    And Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    When Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.