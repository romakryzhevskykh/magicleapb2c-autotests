Feature: Open Manage users page

  Scenario: Check that user able to open Manage Users page
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Manage Users page is opened.
    Then Manage Users title is displayed on Manage Users page.