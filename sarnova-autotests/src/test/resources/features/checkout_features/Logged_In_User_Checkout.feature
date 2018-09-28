Feature: Logged in user checkout functionality

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Empty Cart.
  @SmokeTest
  Scenario: Check that User has access to Checkout Shipping address step.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    Then Check that Checkout Shipping address step is opened.
  @SmokeTest
  Scenario: Check that User can create new Shipping address and proceed to Checkout Shipping method step.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
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
    Then Check that Checkout Shipping method step is opened.
  @SmokeTest
  Scenario: Check that User can place order with default department Shipping address.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    And Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.

#    Scenario: Check that User can place order with selecting another department Shipping address from drop-down.
  @SmokeTest
  Scenario: Check that User can place order with new Shipping address.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
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
    And Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.
    And Check that Shipping Address is correct on Order confirmation page.

#    GROUND Check that shipping price was added to total
#    DAY_2ND Check that shipping price was not added to total
#    OVERNIGHT Check that shipping price was not added to total
  @SmokeTest
  Scenario: Check that User can place order with 2-DAY Shipping method.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Select DAY_2ND shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    And Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.
    And Check that delivery method is correct on Order confirmation page.
  @SmokeTest
  Scenario: Check that User can place order with GROUND Shipping method.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Select GROUND shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    And Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.
    And Check that delivery method is correct on Order confirmation page.
  @SmokeTest
  Scenario: Check that User can place order with OVERNIGHT Shipping method.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Select OVERNIGHT shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    And Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.
    And Check that delivery method is correct on Order confirmation page.
  @SmokeTest
  Scenario: Check that User can place order with Credit card payment.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
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
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.
    And Check that credit card data is correct on Order confirmation page.
  @SmokeTest
  Scenario: Check that User can place order with Invoice payment.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    And Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.
#    Check invoice on Confirmation page
  @SmokeTest
  Scenario: Check that user can place order with Billing address that differs from Shipping address.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
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
    And Click on Change Billing address on Checkout Payment method step.
    And Find any random valid Billing address.
    And Click on Billing Countries drop-down on Checkout Payment method step.
    And Select Billing Country in drop-down on Checkout Payment method step.
    And Fill Billing First name field on Checkout Payment method step.
    And Fill Billing Last name field on Checkout Payment method step.
    And Fill Billing Address line 1 field on Checkout Payment method step.
    And Fill Billing Address line 2 field on Checkout Payment method step.
    And Fill Billing Town field on Checkout Payment method step.
    And Click on Billing States drop-down on Checkout Payment method step.
    And Select Billing State in drop-down on Checkout Payment method step.
    And Fill Billing Zip code field on Checkout Payment method step.
    And Fill Billing Phone number field on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.
    Then Check that Billing Address is correct on Order confirmation page.
  @SmokeTest
  Scenario: Check that Place order button is unable if Terms checkbox is not selected.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    When Click on Checkout button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    And Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    Then Check that Place order button is unable on Checkout Final Review step.

#  Scenario: Check that Saved cards button is absent on Checkout Payment method step.
#    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
#    And Open cart page.
#    And Saved cards list is empty.
#    When Click on Checkout button on Cart page.
#    And Click on Next button on Checkout Shipping address step.
#    And Click on Next button on Checkout Shipping method step.
#    And Select Card payment type on Checkout Payment method step.
#    Then Check that Use Saved card button is not displayed.

#  Scenario: Check that user can place order with Card from Saved cards.
#    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
#    And Open cart page.
#    And At least 1 Saved cards are present.
#    When Click on Checkout button on Cart page.
#    And Click on Next button on Checkout Shipping address step.
#    And Click on Next button on Checkout Shipping method step.
#    And Select Card payment type on Checkout Payment method step.
#    And Find any Saved credit card.
#    And Click on Use saved card button on Checkout Payment method step.
#    And Select your card in Use Saved card pop-up on Checkout Payment method step.
#    And Fill CVV field in Use Saved card pop-up on Checkout Payment method step.
#    And Click on Use saved card button in Use Saved card pop-up on Checkout Payment method step.
#    And Confirm Terms and Conditions on Checkout Final Review step.
#    And Click on Place order on Checkout Final Review step.
#    Then Check that Order confirmation page is opened.
#    Saved credit card on Confirmation page

#  Scenario: Check that user can place order with saving Card to Saved cards.
#    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
#    And Open cart page.
#    When Click on Checkout button on Cart page.
#    And Click on Next button on Checkout Shipping address step.
#    And Click on Next button on Checkout Shipping method step.
#    And Select Card payment type on Checkout Payment method step.
#    And Find any random valid Credit card.
#    And Fill Card Number field on Checkout Payment method step.
#    And Fill Expiry Date(Month) drop-down on Checkout Payment method step.
#    And Fill Expiry Year drop-down on Checkout Payment method step.
#    And Fill Name on card field on Checkout Payment method step.
#    And Fill Card Verification Number field on Checkout Payment method step.
#    And Select Save credit card checkbox on Checkout Payment method step.
#    And Click on Next button on Checkout Payment method step.
#    And Confirm Terms and Conditions on Checkout Final Review step.
#    And Click on Place order on Checkout Final Review step.
#    Then Check that Order confirmation page is opened.
#    When Open Saved Credit cards page.
#    Then Check that saved card is present in the list of Saved cards on Saved credit cards page.
  @SmokeTest
  Scenario: Check Credit card is present in PayFabric after adding card on Checkout Payment method step.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
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
    And Switch to PayFabric agent.
    And User is logged in to Pay Fabric.
    And Set Sandbox to non live key.
    And Open Customer Wallets page in Pay Fabric.
    Then Check that Credit card is displayed on Pay Fabric Wallets page.
  @SmokeTest
  Scenario: Check placed payment is present in PayFabric.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1.
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
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Click on Place order on Checkout Final Review step.
    And Switch to PayFabric agent.
    And User is logged in to Pay Fabric.
    And Set Sandbox to non live key.
    And Open Daily Activity page in Pay Fabric.
    And Click on Run report on Pay Fabric Daily activity page.
    Then Check that transaction is displayed on Pay Fabric Daily activity page.
