Feature: Open Account Management page

  Scenario: Check that user able to open Account Management page
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Account management page is opened.