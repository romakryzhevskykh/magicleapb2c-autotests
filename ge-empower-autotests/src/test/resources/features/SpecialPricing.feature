Feature: Some actions on Special Pricing page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Special Pricing page and correct header title is displayed
    And Special Pricing page is opened.
    Then All Special Pricing title is displayed on Special Pricing page.