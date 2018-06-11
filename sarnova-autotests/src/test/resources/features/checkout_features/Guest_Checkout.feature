Feature: Guest checkout functionality

  Background:
    Given Switch to Storefront guest.
    And Empty Cart.

  Scenario: Check that Guest can open Guest login page.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    Then Check that Guest checkout login page is opened.

  Scenario: Check that Guest can be provided to first Checkout step after Guest login procedure.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Enter email to guest email text field on Guest checkout login page.
    And Enter email to guest confirm email text field on Guest checkout login page.
    And Click on Check out as a Guest button on Guest checkout login page.
    Then Check that Checkout Shipping address step is opened.

  Scenario: Check that Guest can add Shipping address during guest checkout.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Login as guest for checkout on Guest checkout login page.
    And Click on Create new address button on Checkout Shipping address step.
    And Click on Countries drop-down on Checkout Shipping address step.
    And Select Country in drop-down on Checkout Shipping address step.
    And Find any random valid Shipping address.
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

  Scenario: Check that Guest can pass to Payment method step with 2-nd day Shipping method.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Login as guest for checkout on Guest checkout login page.
    And Click on Create new address button on Checkout Shipping address step.
    And Click on Countries drop-down on Checkout Shipping address step.
    And Select Country in drop-down on Checkout Shipping address step.
    And Find any random valid Shipping address.
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
    And Select 2-DAY shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    Then Check that Checkout Payment method step is opened.
    And Check that Card number text field is visible on Checkout Payment method step.

  Scenario: Check that Guest can pass to Payment method step with GROUND day Shipping method.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Login as guest for checkout on Guest checkout login page.
    And Click on Create new address button on Checkout Shipping address step.
    And Click on Countries drop-down on Checkout Shipping address step.
    And Select Country in drop-down on Checkout Shipping address step.
    And Find any random valid Shipping address.
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
    And Select GROUND shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    Then Check that Checkout Payment method step is opened.
    And Check that Card number text field is visible on Checkout Payment method step.

  Scenario: Check that Guest can pass to Payment method step with OVERNIGHT day Shipping method.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Login as guest for checkout on Guest checkout login page.
    And Click on Create new address button on Checkout Shipping address step.
    And Click on Countries drop-down on Checkout Shipping address step.
    And Select Country in drop-down on Checkout Shipping address step.
    And Find any random valid Shipping address.
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
    And Select OVERNIGHT shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    Then Check that Checkout Payment method step is opened.
    And Check that Card number text field is visible on Checkout Payment method step.

  Scenario: Check that Guest has access to card payment type on Payment type step.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Login as guest for checkout on Guest checkout login page.
    And Click on Create new address button on Checkout Shipping address step.
    And Click on Countries drop-down on Checkout Shipping address step.
    And Select Country in drop-down on Checkout Shipping address step.
    And Find any random valid Shipping address.
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
    And Select OVERNIGHT shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    Then Check that Purchase order number text field is visible on Checkout Payment method step.
    And Check that Comment text field is visible on Checkout Payment method step.
    And Check that Card number text field is visible on Checkout Payment method step.
    And Check that Expiry month drop-down is visible on Checkout Payment method step.
    And Check that Expiry year drop-down is visible on Checkout Payment method step.
    And Check that Name on card text field is visible on Checkout Payment method step.
    And Check that CVV text field is visible on Checkout Payment method step.

  Scenario: Check that Guest can pass to Final review step and place order with Card payment type.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Login as guest for checkout on Guest checkout login page.
    And Click on Create new address button on Checkout Shipping address step.
    And Click on Countries drop-down on Checkout Shipping address step.
    And Select Country in drop-down on Checkout Shipping address step.
    And Find any random valid Shipping address.
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
    And Select OVERNIGHT shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    And Find any random valid Credit card.
    And Fill Card Number field on Checkout Payment method step.
    And Fill Expiry Date(Month) drop-down on Checkout Payment method step.
    And Fill Expiry Year drop-down on Checkout Payment method step.
    And Fill Name on card field on Checkout Payment method step.
    And Fill Card Verification Number field on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    Then Check that Checkout Final review step is opened.

  Scenario: Check that Guest can place order.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Login as guest for checkout on Guest checkout login page.
    And Click on Create new address button on Checkout Shipping address step.
    And Click on Countries drop-down on Checkout Shipping address step.
    And Select Country in drop-down on Checkout Shipping address step.
    And Find any random valid Shipping address.
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
    And Select OVERNIGHT shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
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

  Scenario: Check that Guest can place order with changing Billing address.
    When Add to cart VALID product with quantity 1.
    And Open cart page.
    And Click on Checkout button on Cart page.
    And Login as guest for checkout on Guest checkout login page.
    And Click on Create new address button on Checkout Shipping address step.
    And Click on Countries drop-down on Checkout Shipping address step.
    And Select Country in drop-down on Checkout Shipping address step.
    And Find any random valid Shipping address.
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
    And Select OVERNIGHT shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
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

#  Scenario: Check Credit card is present in PayFabric after adding card on Checkout Payment method step.

#  Scenario: Check placed payment is present in PayFabric.