Feature: Guest shopper, I shouldn't have the option to place a replenishment order

  @TestCaseId("SRNV-2688")
  Scenario: Verify that guest user doesn't have [Schedule Replenishment] button on the Checkout Final Review step.
    Given Switch to Storefront guest.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Click on Continue as guest button on Guest checkout login page.
    And Login as guest for checkout on Guest checkout login page.
    And Click on Create new address button on Checkout Shipping address step.
    And Find any random valid Shipping address.
    And Click on Countries drop-down on Checkout Shipping address step.
    And Select Country in drop-down on Checkout Shipping address step.
    And Fill First name field on Checkout Shipping address step.
    And Fill Last name field on Checkout Shipping address step.
    And Fill Address line 1 field on Checkout Shipping address step.
    And Fill Address line 2 field on Checkout Shipping address step.
    And Fill Town field on Checkout Shipping address step.
    And Click on States drop-down on Checkout Shipping address step.
    And Select State in drop-down on Checkout Shipping address step.
    And Fill Zip code field on Checkout Shipping address step.
    And Fill Phone number field on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    And Find any random valid Credit card.
    And Fill Card Number field on Checkout Payment method step.
    And Fill Expiry Date(Month) drop-down on Checkout Payment method step.
    And Fill Expiry Year drop-down on Checkout Payment method step.
    And Fill Name on card field on Checkout Payment method step.
    And Fill Card Verification Number field on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    Then Check that Schedule Replenishment button is displayed on the Final Review step: false.

  @TestCaseId("SRNV-2688") @clearcart
  Scenario: Verify that logged in user has [Schedule Replenishment] button on the Checkout Final Review step.
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    And Select Card payment type on Checkout Payment method step.
    And Find any random valid Credit card.
    And Fill Card Number field on Checkout Payment method step.
    And Fill Expiry Date(Month) drop-down on Checkout Payment method step.
    And Fill Expiry Year drop-down on Checkout Payment method step.
    And Fill Name on card field on Checkout Payment method step.
    And Fill Card Verification Number field on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    Then Check that Schedule Replenishment button is displayed on the Final Review step: true.


