Feature: Some actions on Shipments page

  Scenario: Check that user able to open Shipments page and basic elements are present
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And Shipments page is opened.