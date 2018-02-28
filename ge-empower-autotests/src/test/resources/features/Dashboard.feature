Feature: Some actions on Dashboard page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Dashboard page is opened.

  Scenario: Check that user able to open Dashboard page
    When Order Status widget is displayed.
    And Featured Updates widget is displayed.
    And Order Search widget is displayed.
    And Price and Availability widget is displayed.
    And Recent Orders widget is displayed.
    Then Recent Lists widget is displayed.