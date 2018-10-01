Feature: Open Dashboard page

  Scenario: Check that user able to open Dashboard page
    Given Switch to Storefront as smAdmin.
    And User is logged in to Storefront.
    And Dashboard page is opened.
    When Order Status widget is displayed.
    And Featured Updates widget is displayed.
    And Order Search widget is displayed.
    And Price and Availability widget is displayed.
    And Recent Orders widget is displayed.
    Then Recent Lists widget is displayed.