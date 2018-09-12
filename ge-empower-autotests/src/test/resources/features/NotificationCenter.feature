Feature: Open Notification Center page

  Scenario: Check that user able to open Notification Center page
    Given Switch to Storefront as internalUser.
    And User is logged in to Storefront.
    And Notification Center page is opened.