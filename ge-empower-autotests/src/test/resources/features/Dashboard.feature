Feature: Dashboard elements and widgets checking, Order creation via the P&A block.

  Scenario: Check that user able to open Dashboard page and verify that all widgets are present
    Given Switch to Storefront as smAdmin.
    And User is logged in to Storefront.
    And Dashboard page is opened.