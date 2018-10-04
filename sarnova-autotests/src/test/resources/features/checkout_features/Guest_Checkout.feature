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
    And Click on Continue as guest button on Guest checkout login page.
    And Enter email to guest email text field on Guest checkout login page.
    And Enter email to guest confirm email text field on Guest checkout login page.
    And Click on Check out as a Guest button on Guest checkout login page.
    Then Check that Checkout Shipping address step is opened.

  Scenario: Check that Guest can add Shipping address during guest checkout.
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
    Then Check that Checkout Shipping method step is opened.

    #    GROUND Check that shipping price was added to total
    #    DAY_2ND Check that shipping price was not added to total
    #    OVERNIGHT Check that shipping price was not added to total

  Scenario: Check that Guest can pass to Payment method step with 2-nd day Shipping method.
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
    And Select DAY_2ND shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    Then Check that Checkout Payment method step is opened.
    And Check that Card number text field is visible on Checkout Payment method step.

  Scenario: Check that Guest can pass to Payment method step with GROUND day Shipping method.
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
    And Select GROUND shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    Then Check that Checkout Payment method step is opened.
    And Check that Card number text field is visible on Checkout Payment method step.

  Scenario: Check that Guest can pass to Payment method step with OVERNIGHT day Shipping method.
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
    And Select OVERNIGHT shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    Then Check that Checkout Payment method step is opened.
    And Check that Card number text field is visible on Checkout Payment method step.

  Scenario: Check that Guest has access to card payment type on Payment type step.
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
    And Check that Shipping Address is correct on Order confirmation page.

  Scenario: Check that Guest can place order with changing Billing address.
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
    And Select OVERNIGHT shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
    And Find any random valid Credit card.
    And Fill Card Number field on Checkout Payment method step.
    And Fill Expiry Date(Month) drop-down on Checkout Payment method step.
    And Fill Expiry Year drop-down on Checkout Payment method step.
    And Fill Name on card field on Checkout Payment method step.
    And Fill Card Verification Number field on Checkout Payment method step.
    And Deselect BILLING ADDRESS IS THE SAME AS SHIPPING ADDRESS on Guest Checkout Payment method step.
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
    And Check that Shipping Address is correct on Order confirmation page.
    And Check that Billing Address is correct on Order confirmation page.
    And Check that credit card data is correct on Order confirmation page.
    And Check that delivery method is correct on Order confirmation page.

  Scenario: Check Credit card is present in PayFabric after adding card on Checkout Payment method step.
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
    And Select OVERNIGHT shipping method on Checkout Shipping method step.
    And Click on Next button on Checkout Shipping method step.
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

  Scenario: Check placed payment is present in PayFabric.
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
    And Switch to PayFabric agent.
    And User is logged in to Pay Fabric.
    And Set Sandbox to non live key.
    And Open Daily Activity page in Pay Fabric.
    And Click on Run report on Pay Fabric Daily activity page.
    Then Check that transaction is displayed on Pay Fabric Daily activity page.