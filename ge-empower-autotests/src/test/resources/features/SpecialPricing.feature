Feature: Some actions on Special Pricing page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And Special Pricing page is opened.

  Scenario: Check that user able to open Special Pricing page and correct header title is displayed
    Then All Special Pricing title is displayed on Special Pricing page.