Feature: Check Purchase request by approver

  Background:
    Given Switch to Storefront approver.
    And User is logged in to Storefront.
    And Empty Cart.

  Scenario: Check that created purchase request is present un purchase request list.
    Given Open.
    And Open cart page.
    And Click on Submit purchase request button on Cart page.
    And Click on Next button on Checkout Shipping address step.
    And Click on Next button on Checkout Shipping method step.
    And Select Invoice payment type on Checkout Payment method step.
    And Set any Purchase order number on Checkout Payment method step.
    And Click on Next button on Checkout Payment method step.
    And Confirm Terms and Conditions on Checkout Final Review step.
    And Select valid approver to approve purchase request
    And Click on Place order on Checkout Final Review step.
    Then Check that Order confirmation page is opened.


