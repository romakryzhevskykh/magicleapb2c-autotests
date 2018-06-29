Feature: Some actions on Shipments page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And Shipments page is opened.

  Scenario: Check that user able to open Shipments page and basic elements are present
    When Shipments title is displayed on Shipments page.
    And Color boxes are displayed on Shipments page.
    And Shipment table header is displayed on Shipments page.
    And Help button is displayed.
    Then Feedback button is displayed.

# @todo Continue from this place
#  Scenario: Check that download pop-up can be opened and basic elements are present
#    When Click on Download button on Shipments page.
#    And Check that Download header title is displayed in the Download pop-up on Shipments page.
