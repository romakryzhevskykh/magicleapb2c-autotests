Feature: Some actions on Shipments page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Shipments page is opened.

  Scenario: Check that user able to open Shipments page and basic elements are present
    When Shipments title is displayed on Shipments page.
    And Color boxes are displayed on Shipments page.
    And Shipment table header is displayed on Shipments page.
    And Help button is displayed on Shipments page.
    Then Feedback button is displayed on Shipments page.