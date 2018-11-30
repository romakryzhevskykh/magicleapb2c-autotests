Feature: Customer should see stock warning message when adds more quantity to cart than available (in stock).

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 9999.
    And Add to cart GROUP product with quantity 1.

  @TestCaseId("SRNV-2040")
  Scenario: Verify that customer sees stock warning message on the Cart page
    When Open cart page.
    Then Check that stock warning message for product 1071-10202, PK is displayed on Cart page: true.
    And Check that stock warning message for product 1071-11106, EA is displayed on Cart page: false.

  @TestCaseId("SRNV-2207")
  Scenario: Verify that customer sees stock warning message on the Checkout page
    When Open cart page.
    And Click on Checkout button on Cart page.
    Then Check that stock warning message for product 1071-10202, PK is displayed on Checkout page: true.
    And Check that stock warning message for product 1071-11106, EA is displayed on Checkout page: false.