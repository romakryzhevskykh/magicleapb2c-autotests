Feature: Some actions on Dashboard page

  Background:
    Given Switch to Storefront admin.
    And User is logged in to Storefront.
    And Account management page is opened.
    And Close Account management page.

  Scenario: Check that user able to open Dashboard page
    When Dashboard page is opened.
    And Order Status widget is displayed.
    And Featured Updates widget is displayed.
    And Order Search widget is displayed.
    And Price and Availability widget is displayed.
    And Recent Orders widget is displayed.
    Then Recent Lists widget is displayed.