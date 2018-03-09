Feature: Some actions on Invoice page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Invoice page and correct header title is displayed
    And Invoice page is opened.
    Then All Invoices title is displayed on Invoice page.