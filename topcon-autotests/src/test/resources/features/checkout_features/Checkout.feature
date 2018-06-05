Feature: Checkout flow via Account Payment

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.

  Scenario: Check that order has been placed successfully.
    Given PDP for any product.
    When Set QTY values for products to 2 on PDP.
    And Click on Add to cart button on PDP.
    And Click on Checkout button in Add to cart pop-up on PDP.
    And Click on Checkout button in the Cart window.
    And Set the PO number.
    And Click the Next button.
    And Click the Ship to Accounts button.
    And Click the first Use this Address button.
    And Choose the first Shipment Method in the Shipping Method section.
    And Choose the first Shipping Carrier in the Shipping Method section.
    And Click the Next button in the Shipping Method section.
    And Click the confirmation Terms of Use checkbox.
    And Click the Place Order button.
    Then Check that order has been placed successfully.