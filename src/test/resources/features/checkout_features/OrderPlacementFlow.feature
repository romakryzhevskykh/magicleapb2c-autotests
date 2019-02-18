Feature: Order placement happy passes

  Background: Switch to Storefront user
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.
    And Cart is empty.

  Scenario: Check that shopper can place order without any default data filling Billing data.
    Given User does not have saved Credit Carts/Payment Infos.
    And User does not have default Shipping Address.
    And 1 VALID products are added to cart.
    And VALID Shipping address is generated.
    And VALID Credit card is generated.
    When Open Cart page.
    And Click on Checkout button on Cart page.
    When Select Card Payment in Payment Type step on Checkout.
    And Click on Next button in Payment Type step on Checkout.
    And Fill in Shipping address in Shipping Address step on Checkout.
    And Click on Next button in Shipping Address step on Checkout.
    And Click on Next button in Shipping Method step on Checkout.
    And Set Use my shipping address checkbox unchecked in Payment and Billing Address step on Checkout.
    And Fill in Billing address in Payment and Billing Address step on Checkout.
    And Fill in Credit card data in Payment and Billing Address step on Checkout.
    And Set Save payment method checkbox unchecked in Payment and Billing Address step on Checkout.
    And Click on Next button in Payment and Billing Address step on Checkout.
    And Set Terms and Conditions checkbox as checked in Final review step on Checkout.
    And Click on Place order button in Final review step on Checkout.
    Then Check that Order confirmation page is opened.

  Scenario: Check that shopper can place order without any default data with Billing as Shipping address.
    Given User does not have saved Credit Carts/Payment Infos.
    And User does not have default Shipping Address.
    And 1 VALID products are added to cart.
    And VALID Shipping address is generated.
    And VALID Credit card is generated.
    When Open Cart page.
    And Click on Checkout button on Cart page.
    And Fill in Shipping address in Shipping Address step on Checkout.
    And Click on Next button in Shipping Address step on Checkout.
    And Set Use my shipping address checkbox as checked in Billing Address step on Checkout.
    And Click on Next button in Billing Address step on Checkout.
    And Fill in Credit card data in Payment info step on Checkout.
    And Set Save payment method checkbox unchecked in Payment info step on Checkout.
    And Click on Next button in Payment info step on Checkout.
    And Set Terms and Conditions checkbox as checked in Final review step on Checkout.
    And Click on Place order button in Final review step on Checkout.
    Then Check that Order confirmation page is opened.


  Scenario: Check that shopper can place order with all default data.
    Given User has default Shipping address.
    And User has default Credit card.
    And 1 VALID products are added to cart.
    And Choose default Saved Shipping address.
    And Choose default Saved Credit Card.
    When Open Cart page.
    And Click on Checkout button on Cart page.
    And Fill in CVV code in Final review step on Checkout.
    And Set Terms and Conditions checkbox as checked in Final review step on Checkout.
    And Click on Place order button in Final review step on Checkout.
    Then Check that Order confirmation page is opened.


  Scenario: Check that shopper can place order with only default Shipping address existed(use this address) with only one non clearance product.
    Given User has default Shipping address.
    And User does not have default saved Credit Cart/Payment Info.
    And 1 VALID products are added to cart.
    And Choose default Saved Shipping address.
    And VALID Credit card is generated.
    When Open Cart page.
    And Click on Checkout button on Cart page.
    And Click on Shipping Address Book button in Shipping Address step on Checkout.
    And Select chosen Shipping address in Shipping Address Book pop-up.
    And Set Use my shipping address checkbox as checked in Billing Address step on Checkout.
    And Click on Next button in Billing Address step on Checkout.
    And Fill in Credit card data in Payment info step on Checkout.
    And Set Save payment method checkbox unchecked in Payment info step on Checkout.
    And Click on Next button in Payment info step on Checkout.
    And Set Terms and Conditions checkbox as checked in Final review step on Checkout.
    And Click on Place order button in Final review step on Checkout.
    Then Check that Order confirmation page is opened.


  Scenario: Check that shopper can place order with only default Credit card existed(use this credit card) with only one non clearance product.
    Given User does not have default Shipping Address.
    And User has default Credit card.
    And 1 VALID products are added to cart.
    And VALID Shipping address is generated.
    And Choose default Saved Credit Card.
    When Open Cart page.
    And Click on Checkout button on Cart page.
    And Fill in Shipping address in Shipping Address step on Checkout.
    And Click on Next button in Shipping Address step on Checkout.
    And Set Use my shipping address checkbox as checked in Billing Address step on Checkout.
    And Click on Next button in Billing Address step on Checkout.
    And Click on Saved Payments button in Payment info step on Checkout.
    And Select chosen Credit card in Saved Payments pop-up.
    And Fill in CVV code in Final review step on Checkout.
    And Set Terms and Conditions checkbox as checked in Final review step on Checkout.
    And Click on Place order button in Final review step on Checkout.
    Then Check that Order confirmation page is opened.

#  Scenario: Check that shopper can place order editing previous steps(Start from Shipping address)

#  Scenario: Check that shopper can place order using coupon code
#  Scenario: Check that shopper can place order with price amount > 5000
#  Scenario: Check that shopper can place order with 20 products
#  Scenario: Check that shopper can place order with all product types
#  Scenario: Check that shopper can place order from Saved lists
#  Scenario: Check that shopper can place order with 0 amount(100% discount)
