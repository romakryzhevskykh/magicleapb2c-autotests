Feature: Some actions on Shipments page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And Account management page is opened.
    When Choose North_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Shipments page is opened.

  Scenario: Check that user able to open Shipments page and basic elements are present
    When Shipments title is displayed on Shipments page.
    And Color boxes are displayed on Shipments page.
    And Shipment table header is displayed on Shipments page.
    And Help button is displayed.
    Then Feedback button is displayed.

  Scenario: Check that default Last 50 shipments filter works correctly.
    Then Last 50 shipments filter is displayed by default.
    Then All 50 shipments are available on the Shipments page.
    Then Sum of all shipments in status boxes are equal to 50.

  Scenario: Check that Last 100 shipments filter works correctly.
    When User opens lastNFilters dropdown.
    And Select Last 100 shipments filter.
    Then All 100 shipments are available on the Shipments page.
    Then Sum of all shipments in status boxes are equal to 100.

  Scenario: Check that Last 100 shipments filter works correctly.
    When User opens lastNFilters dropdown.
    And Select Last 200 shipments filter.
    Then Sum of all shipments in status boxes is more than 100 and less or equals to 200.
    Then Paging for shipment dashboard is displayed.
    Then Appropriate count of shipments is available on the Shipments page.

  Scenario: Check that Last week shipment filter works correctly.
    When User opens lastNFilters dropdown.
    And Select Last week shipments filter.
    Then Sum of all shipments in status boxes is more than 1 and less or equals to 200.
    Then Appropriate count of shipments is available on the Shipments page.
    Then Ship date is from week range.