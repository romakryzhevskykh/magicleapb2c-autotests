Feature: Ability to have guest cart merged with active cart when customer logs in

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Empty Cart.

  @SmokeTest @TestCaseId("SRNV-2504")
  Scenario: Verify that guest cart merged with active cart when customer logs in
    Given PDP for INDIVIDUAL, VALID product.
    And Set QTY 1 to any product(UOM) on the PDP.
    And Click on Add to cart button on PDP.
    And User is logged out from Storefront.
    And PDP for INDIVIDUAL, VALID, WITH_MORE_THAN_ONE_UOM product.
    And Set QTY 3 to UOM from the same product that hasn't been selected on PDP.
    And Click on Add to cart button on PDP.
    And User is logged in to Storefront.
    And Open cart page.
    Then Check that only selected UOMs exist on Cart page.
    And Check that selected UOMs have corresponding quantities on Cart page.